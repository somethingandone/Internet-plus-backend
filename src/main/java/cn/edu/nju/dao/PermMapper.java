package cn.edu.nju.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface PermMapper{
    List<String> findPermByUserId(long id);
}
