package cn.edu.nju.service.impl;

import cn.edu.nju.dao.ExRegulationDao;
import cn.edu.nju.dao.InRegulationDao;
import cn.edu.nju.dao.WordFrequencyMapper;
import cn.edu.nju.dao.WordIdfMapper;
import cn.edu.nju.model.ExRegulation;
import cn.edu.nju.model.InRegulation;
import cn.edu.nju.model.WordFrequency;
import cn.edu.nju.model.WordIdf;
import cn.edu.nju.service.WordFrequencyService;
import cn.edu.nju.core.AbstractService;
import cn.edu.nju.utils.VSMUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class WordFrequencyServiceImpl extends AbstractService<WordFrequency> implements WordFrequencyService {
    @Resource
    private WordFrequencyMapper wordFrequencyMapper;

    @Resource
    private WordIdfMapper wordIdfMapper;

    @Resource
    private InRegulationDao inRegulationDao;

    @Resource
    private ExRegulationDao exRegulationDao;

    /**
     * calculateWordFrequency
     * 计算所有词频。谨慎使用该方法！
     * @return void
     * @author haofeng.Yu
     */
    @Override
    public void calculateWordFrequencyAll() throws Exception {
        List<String> allText = exRegulationDao.findAll().stream().map(ExRegulation::getText).collect(Collectors.toList());
        allText.addAll(inRegulationDao.findAll().stream().map(InRegulation::getContent).collect(Collectors.toList()));
        HashMap<String, Integer> dict = new HashMap<>();
        HashMap<String, Float> idf_dict = new HashMap<>();
        for (String text: allText
             ) {
            List<String> cutList = VSMUtil.segment(text);
            for (String word: cutList
                 ) {
                if(dict.containsKey(word)){
                    dict.replace(word, dict.get(word)+1);
                }else{
                    dict.put(word, 1);
                }

            }
            HashSet<String> cutSet = new HashSet<>(cutList);

            for (String word: cutSet
            ) {
                if(idf_dict.containsKey(word)){
                    idf_dict.replace(word, idf_dict.get(word)+1);
                }else{
                    idf_dict.put(word, 1.0f);
                }
            }
        }
        dict.forEach((word, freq)->{
            idf_dict.replace(word,
                    (float) Math.log10((double)allText.size()
                            /(double) (idf_dict.get(word)+1)));
        });
        List<WordIdf> idfRes = idf_dict.entrySet().stream()
                .filter(set-> set.getKey().charAt(0)> '\u4e00'
                        && set.getKey().charAt(0)<='\u9fa5')
                .map(set-> WordIdf.builder()
                        .word(set.getKey()).
                        idf(set.getValue()).build())
                .collect(Collectors.toList());

        List<WordFrequency> res = dict.entrySet().stream()
                .filter(set-> set.getKey().charAt(0)> '\u4e00'
                        && set.getKey().charAt(0)<='\u9fa5')
                .map(set-> WordFrequency.builder()
                        .word(set.getKey())
                        .frequency(set.getValue()).build())
                .collect(Collectors.toList());
        wordIdfMapper.insertList(idfRes);
        wordFrequencyMapper.insertList(res);
    }
}
