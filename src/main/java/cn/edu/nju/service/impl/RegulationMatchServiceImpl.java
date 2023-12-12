package cn.edu.nju.service.impl;

import cn.edu.nju.dao.InRegulationSplitDao;
import cn.edu.nju.model.InRegulationSplit;
import cn.edu.nju.model.VO.InRegulationMatchVO;
import cn.edu.nju.model.VO.MatchItem;
import cn.edu.nju.model.VO.RegulationRetrievalVO;
import cn.edu.nju.service.RegulationMatchService;
import cn.edu.nju.utils.VSMUtil;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 完成分词、计算TF-IDF相似度
 */
@Service
public class RegulationMatchServiceImpl implements RegulationMatchService {
    @Autowired
    private InRegulationSplitDao inRegulationSplitDao;

    //选取关键词的数量（向量维度）
    @Value("${match.topK}")
    public int topK;

    //结果数组的最大长度
    @Value("${match.resultLimit}")
    public int resultLimit;
    /**
     * retrieval
     * 匹配一段文本，并返回待匹配结果的列表
     * @param regulationRetrievalVO 待匹配文本id 内容
     * @return MatchItem
     * @author haofeng.Yu
     */
    public List<MatchItem> retrieval(RegulationRetrievalVO regulationRetrievalVO) {
        ArrayList<MatchItem> matchResult = new ArrayList<>();
        //获取关键词
        Map<String, Float> keywords = VSMUtil.getKeyword(regulationRetrievalVO.getText(), topK);
        assert keywords != null;
        if(keywords.size() <= topK){
            //过短
            //TODO 异常处理
            return null;
        }
        //获取到待匹配的内规条目 注意！这里已经筛选了包含关键词的条目！
        List<InRegulationSplit> inRegulationSplits = inRegulationSplitDao.getInRegulationByKeywords(keywords.keySet());
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
     * getRelevance
     * 根据标注结果获取两篇文章是否相关（参考群里杨昭彤发的sql）
     * @param exRegulationName 外规名称
     * @param inRegulationName 内规名称
     * @return boolean 是否相关
     * @author haofeng.Yu
     */
    public boolean getRelevance(String exRegulationName, String inRegulationName){
        //TODO  @何青云 根据标注结果获取两篇文章是否相关（参考群里杨昭彤发的sql）
        return false;
    }

    /**
     * evaluateSimilarity
     * 计算相似度
     * @param exKeywords 外规的关键词:TF-IDF 向量表
     * @param inRegulationSplit 内规条目
     * @return float 相似度
     * @author haofeng.Yu
     */
    private float evaluateSimilarity(Map<String,Float> exKeywords, InRegulationSplit inRegulationSplit){
        //TODO @余灏沣 计算相似度
        //计算每一个exKeyword在 inRegulationSplit中的词频
        //inRegulationSplit中 _words项已经完成分词操作
        HashMap<String, Integer> inWordFrequency = VSMUtil.getWordFrequency(inRegulationSplit.getItemContent());

        //外规的词向量
        ArrayList<Float> exVector = new ArrayList<>();
        //内规的词向量
        ArrayList<Float> inVector = new ArrayList<>();

        exKeywords.forEach((word, score) -> {
            exVector.add(score);
            if(!inWordFrequency.containsKey(word)){
                inVector.add(0f);
            }else{
                inVector.add(inWordFrequency.get(word)*VSMUtil.getIDF(word));
            }
        });

        //计算相似度
        float similarity = VSMUtil.cosine(exVector, inVector);
        return similarity;
    }




}
