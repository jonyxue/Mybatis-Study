import com.xue.dao.UserMapper;
import com.xue.pojo.User;
import com.xue.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyTest {
    static Logger logger=Logger.getLogger(MyTest.class);

   /* @Test*/
    /*public void test(){
        //第一步，获取SqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        try {
            //*推荐使用方式1*//*
            //方式1：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//获取UserDao对象
            List<User> userList = mapper.getUserList();
            //方式二：
           /* List<User> userList = sqlSession.selectList("com.xue.dao.UserMapper.getUserList");*/
            /*for (User user : userList) {
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
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);//获取mapper对象
        List<User> userlist = mapper.getUserLike("李");
        for (User user : userlist) {
            System.out.println(user);
        }
        logger.info("测试，进入成功");

        sqlSession.close();
    }
    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");

    }
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("startIndex",1);
        map.put("pageSize",2);
        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //Rowbounds实现分页
        RowBounds rowBounds = new RowBounds(2, 2);
        /*通过java代码实现分页*/
        List<User> userlist = sqlSession.selectList("com.xue.dao.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User user : userlist) {
            System.out.println(user);
        }
    }

}
