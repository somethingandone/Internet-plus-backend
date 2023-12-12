package cn.edu.nju;

import cn.edu.nju.dao.WordIdfMapper;
import cn.edu.nju.model.WordIdf;
import org.junit.Test;

import javax.annotation.Resource;

public class WordIdfDaoTest extends Tester{
    @Resource
    WordIdfMapper wordIdfMapper;

    @Test
    public void test1(){
        WordIdf wordIdf = wordIdfMapper.getIdf("个人收入");
        System.out.println(wordIdf.getIdf());
    }
}
