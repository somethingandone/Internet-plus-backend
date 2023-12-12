package cn.edu.nju.service.impl;

import cn.edu.nju.dao.WordIdfMapper;
import cn.edu.nju.model.WordIdf;
import cn.edu.nju.service.WordIdfService;
import cn.edu.nju.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2023/12/12.
 */
@Service
@Transactional
public class WordIdfServiceImpl extends AbstractService<WordIdf> implements WordIdfService {
    @Resource
    private WordIdfMapper wordIdfMapper;

}
