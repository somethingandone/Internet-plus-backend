package cn.edu.nju.service.impl;

import cn.edu.nju.dao.InRegulationSplitDao;
import cn.edu.nju.dao.WordIdfMapper;
import cn.edu.nju.model.InRegulationSplit;
import cn.edu.nju.model.User;
import cn.edu.nju.model.VO.InRegulationMatchVO;
import cn.edu.nju.model.VO.MatchItem;
import cn.edu.nju.model.VO.RegulationRetrievalVO;
import cn.edu.nju.model.WordIdf;
import cn.edu.nju.service.RegulationMatchService;
import cn.edu.nju.utils.RedisCache;
import cn.edu.nju.utils.VSMUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
/**
 * 完成分词、计算TF-IDF相似度
 */
@Service
public class RegulationMatchServiceImpl implements RegulationMatchService {
    @Autowired
    private InRegulationSplitDao inRegulationSplitDao;

    @Autowired
    private RedisCache redisCache;

    @Resource
    private WordIdfMapper wordIdfMapper;

    //选取关键词的数量（向量维度）
    @Value("${match.topK}")
    public int topK;

    //结果数组的最大长度
    @Value("${match.resultLimit}")
    public int resultLimit;

    private Map<String, WordIdf> idfDict;

    static final float d = 0.85f;
    /**
     * 最大迭代次数
     */
    static final int max_iter = 200;
    static final float min_diff = 0.001f;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void init(){
        this.idfDict = new HashMap<>();
        List<WordIdf> wordIdfList = wordIdfMapper.selectAll();
        this.idfDict = wordIdfList.stream().collect(Collectors.toMap(WordIdf::getWord, wordIdf -> wordIdf));
    }


    /**
     * retrieval
     * 匹配一段文本，并返回待匹配结果的列表
     * @param regulationRetrievalVO 待匹配文本id 内容
     * @return MatchItem
     * @author haofeng.Yu
     */
    public List<MatchItem> retrieval(RegulationRetrievalVO regulationRetrievalVO) throws Exception {
        ArrayList<MatchItem> matchResult = new ArrayList<>();
        //获取关键词
        List<Pair<String, Float>> keywords = getKeywordTFIDF(regulationRetrievalVO.getTitle(), regulationRetrievalVO.getText());
        if(keywords.size() < topK){
            //过短
            //TODO checked 异常处理
            System.err.println("过短！");
            return null;
        }
        //获取到待匹配的内规条目 注意！这里已经筛选了包含关键词的条目！
        List<String> keywordStrs = keywords.stream().map(pair->pair.getLeft()).collect(Collectors.toList());
        List<InRegulationSplit> inRegulationSplits = inRegulationSplitDao.getInRegulationByKeywords(keywordStrs);
        //为上述内规条目评分的结果容器
        List<Pair<Integer, Float>> indexScorePair = new ArrayList<>();

        for(int index = 0; index < inRegulationSplits.size(); ++index){
            indexScorePair.add(Pair.of(index,
                    evaluateSimilarity(keywords, inRegulationSplits.get(index))));
        }
        //根据相似度降序排列
        indexScorePair.sort((o1, o2)-> -o1.getRight().compareTo(o2.getRight()));
        //截取前limit项
        indexScorePair = indexScorePair.stream().limit(resultLimit).collect(Collectors.toList());
        //装载到结果里面去
        indexScorePair.forEach(pair -> {
            InRegulationSplit inRegulationSplit = inRegulationSplits.get(pair.getLeft());
            MatchItem matchItem = MatchItem.builder()
                    .fileName(inRegulationSplit.getTitle())
                    .text(inRegulationSplit.getItemContent())
                    .similarity(pair.getRight())
                    .relevance(getRelevance(regulationRetrievalVO.getTitle(), inRegulationSplit.getTitle()))
                    .build();
            matchResult.add(matchItem);
        });
        return matchResult;
    }

    /**
     * getKeyword
     * 注意，这里是对待匹配的文本，也就是外规的一段进行分词。
     * 1.可以考虑采用textrank分词，这种分词方式不依赖语料库，而是上下文。但是最终要记录权重值得分
     * 我不确定这两种方式的权重得分是否会有很大差距导致结果不同，可以查一查资料
     * 2.也可考虑使用tf-idf分词。词频词库应该已经记录好，所以只需要计算本文中所有词语的tf即可，提取其中值最高的n项。
     * @param text 文本
     * @return Map<String, Float> 词语: 得分(tf-idf值)
     * @author haofeng.Yu
     */
    public List<Pair<String, Float>> getKeywordTFIDF(String title, String text) throws Exception {
        //TODO checked @胡国栋 分词并获取关键词及其tfidf得分 建议和下面的getWordFrequency抽象一个分词函数
        Map<String, Float> keywords = new HashMap<>();
        Map<String, Integer> wordCount = VSMUtil.wordCount(title+text);
        wordCount.forEach((word,cnt)->{
            WordIdf wordIdf = wordIdfMapper.getIdf(word);
            if(Objects.isNull(wordIdf)){
                keywords.put(word, 0f);
            }else{
                keywords.put(word, cnt*wordIdf.getIdf());
            }
        });
        List<Pair<String, Float>> keywordsVec;
        keywordsVec = keywords.entrySet().stream().map(set->Pair.of(set.getKey(),set.getValue())).collect(Collectors.toList());
        keywordsVec.sort((a, b)-> -a.getRight().compareTo(b.getRight()));
        keywordsVec = keywordsVec.stream().limit(topK).collect(Collectors.toList());
        return keywordsVec;
    }

    public List<Pair<String, Float>> getKeywordTextRank(String title, String content) throws Exception{
        List<String> wordList = VSMUtil.segment(title + content);
        Map<String, Set<String>> words = new HashMap<String, Set<String>>();
        Queue<String> que = new LinkedList<String>();
        for (String w : wordList) {
            if (!words.containsKey(w)) {
                words.put(w, new HashSet<String>());
            }
            que.offer(w);
            if (que.size() > 5) {
                que.poll();
            }
            for (String w1 : que) {
                for (String w2 : que) {
                    if (w1.equals(w2)) {
                        continue;
                    }
                    words.get(w1).add(w2);
                    words.get(w2).add(w1);
                }
            }
        }
        Map<String, Float> score = new HashMap<String, Float>();
        for (int i = 0; i < max_iter; ++i) {
            Map<String, Float> m = new HashMap<String, Float>();
            float max_diff = 0;
            for (Map.Entry<String, Set<String>> entry : words.entrySet()) {
                String key = entry.getKey();
                Set<String> value = entry.getValue();
                m.put(key, 1 - d);
                for (String other : value) {
                    int size = words.get(other).size();
                    if (key.equals(other) || size == 0) continue;
                    m.put(key, m.get(key) + d / size * (score.get(other) == null ? 0 : score.get(other)));
                }
                max_diff = Math.max(max_diff, Math.abs(m.get(key) - (score.get(key) == null ? 0 : score.get(key))));
            }
            score = m;
            if (max_diff <= min_diff) break;
        }
        List<Pair<String, Float>> keywordsVec;
        keywordsVec = score.entrySet().stream().map(set->Pair.of(set.getKey(),set.getValue())).collect(Collectors.toList());
        keywordsVec.sort((a, b)-> -a.getRight().compareTo(b.getRight()));
        keywordsVec = keywordsVec.stream().limit(topK).collect(Collectors.toList());
        return keywordsVec;
    }

    /**
     * getRelevance
     * 根据标注结果获取两篇文章是否相关（参考群里杨昭彤发的sql）
     * @param exRegulationName 外规名称
     * @param inRegulationName 内规名称
     * @return boolean 是否相关
     * @author haofeng.Yu
     */
    public boolean getRelevance(String exRegulationName, String inRegulationName){
//        //TODO  @何青云 根据标注结果获取两篇文章是否相关（参考群里杨昭彤发的sql）
//        // 查询SQL语句
//        String query = "SELECT * FROM relation WHERE exRegulation = ? AND inRegulation = ?";
//
//        // 执行查询
//        Integer count = jdbcTemplate.queryForObject(query, Integer.class, exRegulationName, inRegulationName);
//
//        // 如果查询结果不为null且大于0，则说明存在关联关系
//        return count != null && count > 0;
        return true;
    }

    /**
     * evaluateSimilarity
     * 计算相似度
     * @param exKeywords 外规的关键词:TF-IDF 向量表
     * @param inRegulationSplit 内规条目
     * @return float 相似度
     * @author haofeng.Yu
     */
    private float evaluateSimilarity(List<Pair<String,Float>> exKeywords, InRegulationSplit inRegulationSplit) throws Exception {
        //TODO checked @余灏沣 计算相似度
        //计算每一个exKeyword在 inRegulationSplit中的词频
        //inRegulationSplit中 _words项已经完成分词操作
        Map<String, Integer> inWordFrequency = VSMUtil.wordCount(inRegulationSplit.getItemContent());

        //外规的词向量
        ArrayList<Float> exVector = new ArrayList<>();
        //内规的词向量
        ArrayList<Float> inVector = new ArrayList<>();

        exKeywords.forEach(pair -> {
            exVector.add(pair.getRight());
            if(!inWordFrequency.containsKey(pair.getLeft())){
                inVector.add(0f);
            }else{
                float tf = inWordFrequency.get(pair.getLeft());
                WordIdf wordIdf = idfDict.get(pair.getLeft());
                if(!Objects.isNull(wordIdf)){
                    inVector.add(tf*wordIdf.getIdf());
                }else{
                    inVector.add(1f);
                }

            }
        });

        //计算相似度
        float similarity = VSMUtil.cosine(exVector, inVector);
        return similarity;
    }




}
