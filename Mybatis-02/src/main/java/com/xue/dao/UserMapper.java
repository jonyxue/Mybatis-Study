package com.xue.dao;

import com.xue.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();
    User getUserById(int id);

    List<User> getUserLike(String value);
    int addUser(User user);
    int addUser2(Map<String,Object> map);

    int updateUser(User user);

    int deleUser(int id);


}
