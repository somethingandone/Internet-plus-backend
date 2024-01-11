package cn.edu.nju.service.impl;

import cn.edu.nju.core.AbstractMongoService;
import cn.edu.nju.dao.InRegulationDao;
import cn.edu.nju.model.InRegulation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class InRegulationServiceImpl extends AbstractMongoService<InRegulation>{

    @Resource
    InRegulationDao inRegulationDao;

    @Override
    public void save(InRegulation inRegulation) {
        inRegulationDao.save(inRegulation);
    }

    @Override
    public List<InRegulation> findAll() {
        return inRegulationDao.findAll();
    }

    public int count(InRegulation inRegulation) {
        return Math.toIntExact(inRegulationDao.selectCount(inRegulation));
    }
}
