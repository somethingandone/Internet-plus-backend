package cn.edu.nju.service.impl;

import cn.edu.nju.dao.ExRegulationDao;
import cn.edu.nju.model.ExRegulation;
import cn.edu.nju.service.ExRegulationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ExRegulationServiceImpl implements ExRegulationService {
    @Resource
    ExRegulationDao exRegulationDao;

    @Override
    public void save(ExRegulation exRegulation) {
        exRegulationDao.save(exRegulation);
    }

    @Override
    public List<ExRegulation> findAll() {
        return exRegulationDao.findAll();
    }
}