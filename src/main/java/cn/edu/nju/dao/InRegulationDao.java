package cn.edu.nju.dao;

import cn.edu.nju.core.AbstractMongoService;
import cn.edu.nju.core.MongoDao;
import cn.edu.nju.model.InRegulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InRegulationDao extends MongoDao<InRegulation> {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<InRegulation> findAll(){
        return mongoTemplate.findAll(InRegulation.class);
    }

    public void save(InRegulation inRegulation){
        mongoTemplate.save(inRegulation);
    }

    @Override
    protected Class<InRegulation> getEntityClass() {
        return InRegulation.class;
    }
}
