package cn.edu.nju;

import cn.edu.nju.dao.InRegulationSplitDao;
import cn.edu.nju.model.InRegulationSplit;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InRegulationSplitDaoTest extends Tester{
    @Autowired
    private InRegulationSplitDao inRegulationSplitDao;

    @Test
    public void test1(){
        List<String> ss = new ArrayList<>();
        ss.add("业务管理");
        List<InRegulationSplit> res = inRegulationSplitDao.getInRegulationByKeywords(ss);
        System.out.println(res.size());
    }
}
