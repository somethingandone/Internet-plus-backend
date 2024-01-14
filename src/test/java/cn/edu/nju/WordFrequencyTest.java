package cn.edu.nju;

import cn.edu.nju.service.WordFrequencyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

//@Rollback(value = false)
public class WordFrequencyTest extends Tester{
    @Autowired
    WordFrequencyService wordFrequencyService;
    @Test
    public void calculateAll() throws Exception {
//        wordFrequencyService.calculateWordFrequencyAll();
    }
}
