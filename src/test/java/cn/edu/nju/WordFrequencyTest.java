package cn.edu.nju;

import cn.edu.nju.service.WordFrequencyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class WordFrequencyTest extends Tester{
    @Autowired
    WordFrequencyService wordFrequencyService;
    @Test
    public void calculateAll() throws Exception {
//        wordFrequencyService.calculateWordFrequencyAll();
    }
}
