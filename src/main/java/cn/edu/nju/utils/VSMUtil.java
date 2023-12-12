package cn.edu.nju.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VSMUtil {
    /**
     * cosine
     * 计算向量余弦
     * @param vec1
     * @param vec2
     * @return float
     * @author haofeng.Yu
     */
    public static float cosine(ArrayList<Float> vec1, ArrayList<Float> vec2){
        if(vec1.size()!= vec2.size()){
            throw new RuntimeException("向量维度不匹配");
        }
        float dotProduct = 0;
        float magnitude1 = 0;
        float magnitude2 = 0;
        for(int i = 0; i < vec1.size(); i++){
            dotProduct += vec1.get(i)*vec2.get(i);
            magnitude1 += Math.pow(vec1.get(i), 2);
            magnitude2 += Math.pow(vec2.get(i), 2);
        }
        magnitude1 = (float) Math.sqrt(magnitude1);
        magnitude2 = (float) Math.sqrt(magnitude2);
        return dotProduct/(magnitude1*magnitude2);
    }

    /**
     * getIDF
     * 获取指定词语的idf。如果有则直接从数据库拿。
     * 如果没有，则计算idf并存入数据库
     * @param word description
     * @return float
     * @author haofeng.Yu
     */
    public static float getIDF(String word){
        //TODO @何青云 获取指定词语的idf。如果有则直接从数据库拿。 如果没有，则计算idf并存入数据库
        return 0;
    }

    /**
     * getKeyword
     * 注意，这里是对待匹配的文本，也就是外规的一段进行分词。
     * 1.可以考虑采用textrank分词，这种分词方式不依赖语料库，而是上下文。但是最终要记录权重值得分
     * 我不确定这两种方式的权重得分是否会有很大差距导致结果不同，可以查一查资料
     * 2.也可考虑使用tf-idf分词。词频词库应该已经记录好，所以只需要计算本文中所有词语的tf即可，提取其中值最高的n项。
     * @param text description
     * @return Map<String, Float> 词语: 得分(tf-idf值)
     * @author haofeng.Yu
     */
    public static Map<String, Float> getKeyword(String text, int K){
        //TODO @胡国栋 分词并获取关键词及其tfidf得分 建议和下面的getWordFrequency抽象一个分词函数
        return null;
    }

    /**
     * getWordFrequency
     * 先对content进行分词，再计算词频
     * @param content 待计算的文本
     * @return java.util.HashMap<java.lang.String,java.lang.Integer> 词语：词频
     * @author haofeng.Yu
     */
    public static HashMap<String, Integer> getWordFrequency(String content){
        //TODO @胡国栋 先对content进行分词，再计算词频 建议和上面的getKeyword抽象一个分词函数
        return null;
    }
}
