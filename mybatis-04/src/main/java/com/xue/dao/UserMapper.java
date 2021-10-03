package com.xue.dao;

import com.xue.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();
    //根据id查询用户
    User getUserById(int id);

    List<User> getUserLike(String value);

    //分页
    List<User> getUserByLimit(Map<String,Integer> map);
    //通过RowBounds实现分页
    List<User> getUserByRowBounds();

}
