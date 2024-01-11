package cn.edu.nju.dao;

import cn.edu.nju.core.AbstractMongoService;
import cn.edu.nju.core.MongoDao;
import cn.edu.nju.model.ExRegulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExRegulationDao extends MongoDao<ExRegulation> {
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<ExRegulation> findAll(){
        return mongoTemplate.findAll(ExRegulation.class);
    }
    public void save(ExRegulation exRegulation){
        mongoTemplate.save(exRegulation);
    }

    @Override
    protected Class<ExRegulation> getEntityClass() {
        return ExRegulation.class;
    }
}
