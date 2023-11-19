package cn.edu.nju.dao;

import cn.edu.nju.model.User;
import cn.edu.nju.core.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    List<User> findAll();

    User findUserByName(String name);

    int createUser(User userPO);
}
