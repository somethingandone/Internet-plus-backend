package cn.edu.nju.dao;

import cn.edu.nju.model.InRegulation;
import cn.edu.nju.model.InRegulationSplit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class InRegulationSplitDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<InRegulationSplit> getInRegulationByKeywords(List<String> keywords){
        Query query = new Query();
        String[] keywordsArray = keywords.toArray(new String[0]);
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matching(String.join(" ",keywordsArray));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, InRegulationSplit.class);
    }
}
