package cn.edu.nju.dao;

import cn.edu.nju.model.InRegulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InRegulationDao {
    @Autowired
    public MongoTemplate mongoTemplate;

    public void save(InRegulation inRegulation){
        mongoTemplate.save(inRegulation);
    }
}
