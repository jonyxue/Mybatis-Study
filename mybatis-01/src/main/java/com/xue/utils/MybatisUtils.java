package com.xue.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


//SqlSessionFactory -->sqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用mybatis第一步
            //获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*有sqlSessionFactory，我们就可以获得SqlSession的实例了，SqlSession
            完全包含了面向数据库执行Sql命令所需要的所有方法
             */
    public static SqlSession getSqlSession(){
        /*SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;*/
        return sqlSessionFactory.openSession();
    }

}
