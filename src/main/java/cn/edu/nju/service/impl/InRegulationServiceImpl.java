package cn.edu.nju.service.impl;

import cn.edu.nju.dao.InRegulationDao;
import cn.edu.nju.model.InRegulation;
import cn.edu.nju.service.InRegulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class InRegulationServiceImpl implements InRegulationService {

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
}
