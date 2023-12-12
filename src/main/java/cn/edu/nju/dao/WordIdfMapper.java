package cn.edu.nju.dao;

import cn.edu.nju.core.Mapper;
import cn.edu.nju.model.WordIdf;

public interface WordIdfMapper extends Mapper<WordIdf> {
    WordIdf getIdf(String word);
}
