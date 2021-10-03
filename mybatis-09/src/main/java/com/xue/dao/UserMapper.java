package com.xue.dao;

import com.xue.pojo.User;
import com.xue.utils.MybatisUtils;

public interface UserMapper {
    User queryUserById(int id);
}
