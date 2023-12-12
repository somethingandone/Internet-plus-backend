package cn.edu.nju.utils;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import org.apache.cxf.helpers.FileUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VSMUtil {
    public static final JiebaSegmenter segmenter = new JiebaSegmenter();
    static List<String> stopWords = new ArrayList<>();

    private static String stopWordsPath = "src/main/resources/stopwords.txt";

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
        float res = dotProduct/(magnitude1*magnitude2);
        if(Float.isNaN(res)){
            return 0;
        }
        if(res > 0.8f){
            System.out.println(vec1);
        }
        return res;
    }


    /**
     * wordCount
     * 先对text进行分词，再计算词频
     * @param text 待计算的文本
     * @return java.util.HashMap<java.lang.String,java.lang.Integer> 词语：词频
     * @author haofeng.Yu
     */
    public static Map<String, Integer> wordCount(String text) throws Exception {
        //TODO checked @胡国栋 先对content进行分词，再计算词频 建议和上面的getKeyword抽象一个分词函数
        List<String> words = segmentAccurate(text);
        Map<String, Integer> wordCount = new HashMap<>();
        words.forEach(word->{
            if(wordCount.containsKey(word)){
                wordCount.replace(word, wordCount.get(word)+1);
            }else{
                wordCount.put(word, 1);
            }
        });
        return wordCount;
    }

    public static void init() throws Exception {
        stopWords = FileUtils.readLines(new File(stopWordsPath));
    }

    public static List<String> segment(String text) throws Exception {
        if(stopWords.size() == 0){
            init();
        }
        List<SegToken> words = segmenter.process(text, JiebaSegmenter.SegMode.INDEX);
        return words.stream().filter(word -> !stopWords.contains(word.word)).map(word -> word.word).collect(Collectors.toList());
    }

    public static List<String> segmentAccurate(String text) throws Exception {
        if(stopWords.size() == 0){
            init();
        }
        List<SegToken> words = segmenter.process(text, JiebaSegmenter.SegMode.SEARCH);
        return words.stream().filter(word -> !stopWords.contains(word.word)).map(word -> word.word).collect(Collectors.toList());
    }
}
