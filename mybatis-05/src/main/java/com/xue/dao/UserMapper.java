package com.xue.dao;

import com.xue.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getusers();

    @Update("update user set username=#{username},password=#{pwd} where id=#{id}")
    int update(User user);



}
