package cn.edu.nju.dao;

import cn.edu.nju.model.ExRegulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExRegulationDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<ExRegulation> findAll(){
        return mongoTemplate.findAll(ExRegulation.class);
    }
    public void save(ExRegulation exRegulation){
        mongoTemplate.save(exRegulation);
    }
}
