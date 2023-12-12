package cn.edu.nju.service;
import cn.edu.nju.model.WordFrequency;
import cn.edu.nju.core.Service;


/**
 * Created by CodeGenerator on 2023/12/12.
 */
public interface WordFrequencyService extends Service<WordFrequency> {
    void calculateWordFrequencyAll() throws Exception;
}
