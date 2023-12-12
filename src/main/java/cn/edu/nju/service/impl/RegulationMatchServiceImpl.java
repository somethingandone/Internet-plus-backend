package cn.edu.nju.service.impl;

import cn.edu.nju.dao.InRegulationSplitDao;
import cn.edu.nju.model.InRegulationSplit;
import cn.edu.nju.model.VO.InRegulationMatchVO;
import cn.edu.nju.model.VO.MatchItem;
import cn.edu.nju.model.VO.RegulationRetrievalVO;
import cn.edu.nju.service.RegulationMatchService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * 完成分词、计算TF-IDF相似度
 */
@Service
public class RegulationMatchServiceImpl implements RegulationMatchService {
    @Autowired
    private InRegulationSplitDao inRegulationSplitDao;

    @Value("${match.topK}")
    public int topK;
    /**
     * retrieval
     * 匹配一段文本，并返回待匹配结果的列表
     * @param regulationRetrievalVO 待匹配文本id 内容
     * @return java.util.List<cn.edu.nju.model.VO.MatchItem>
     * @author haofeng.Yu
     */
    public List<MatchItem> retrieval(RegulationRetrievalVO regulationRetrievalVO) {
//        TODO
        ArrayList<MatchItem> matchResult = new ArrayList<>();
        //获取关键词
        Map<String, Float> keywords = getKeyword(regulationRetrievalVO.getText(), topK);
        assert keywords != null;
        if(keywords.size() <= topK){
            //过短
            return null;
        }
        //获取到待匹配的内规条目
        List<InRegulationSplit> inRegulationSplits = inRegulationSplitDao.getInRegulationByKeywords(keywords.keySet());
        //为上述内规条目评分的结果容器
        List<Pair<Integer, Float>> indexScorePair = new ArrayList<>();

        for(int index = 0; index < inRegulationSplits.size(); ++index){
            indexScorePair.add(Pair.of(index,
                    evaluateSimilarity(keywords, inRegulationSplits.get(index))));
        }
        return null;
    }

    /**
     * getKeyword
     * 1.可以考虑采用textrank分词，这种分词方式不依赖语料库，而是上下文。
     * 2.也可考虑使用tf-idf分词。词频词库应该已经记录好，所以只需要计算本文中所有词语的tf即可，提取其中值最高的n项。
     * @param text description
     * @return Map<String, Float> 词语: 得分(tf-idf值)
     * @author haofeng.Yu
     */
    private Map<String, Float> getKeyword(String text, int K){
        //TODO
        return null;
    }

    /**
     * evaluateSimilarity
     * @param exKeywords 外规的关键词:TF-IDF 向量表
     * @param inRegulationSplit 内规条目
     * @return float 相似度
     * @author haofeng.Yu
     */
    private float evaluateSimilarity(Map<String,Float> exKeywords, InRegulationSplit inRegulationSplit){
        //TODO
        //计算每一个exKeyword在 inRegulationSplit中的词频
        //inRegulationSplit中 _words项已经完成分词操作
        HashMap<String, Integer> inWordFrequency = getWordFrequency(exKeywords.keySet(), inRegulationSplit.getItemContent());

        //外规的词向量
        ArrayList<Float> exVector = new ArrayList<Float>(exKeywords.values());
        //内规的词向量
        ArrayList<Float> inVector = new ArrayList<Float>();

        //计算相似度
        return 0f;
    }

    /**
     * getWordFrequency
     * 先对content进行分词，再计算key在其中出现的次数
     * @param keys 哪些词语
     * @param content 待计算的文本
     * @return java.util.HashMap<java.lang.String,java.lang.Integer> 词语：词频
     * @author haofeng.Yu
     */
    private HashMap<String, Integer> getWordFrequency(Set<String> keys, String content){
        //TODO
        return null;
    }
}
