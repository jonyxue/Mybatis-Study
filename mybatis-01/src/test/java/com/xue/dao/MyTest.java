package com.xue.dao;

import com.xue.pojo.User;
import com.xue.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    /*@Test
    public void test(){
        //第一步，获取SqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        try {
            *//*推荐使用方式1*//*
            //方式1：getMapper
             UserMapper mapper = sqlSession.getMapper(UserMapper.class);//获取UserDao对象
            List<User> userList = mapper.getUserList();
            //方式二：
           *//* List<User> userList = sqlSession.selectList("com.xue.dao.UserMapper.getUserList");*//*
            for (User user : userList) {
                System.out.println(user);
            }
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }*/

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userlist = mapper.getUserLike("李");
        for (User user : userlist) {
            System.out.println(user);
        }

        sqlSession.close();
    }
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }
    //注意增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(4, "赵六", "789"));
        if(res>0){
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void updateUser(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(1,"老黑","234"));
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void deleUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleUser(4);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("id",5);
        map.put("ur","老王涛");
        map.put("pwd","458");
        mapper.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }

}
