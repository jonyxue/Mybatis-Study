import com.xue.dao.UserMapper;
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
       */
  /*  @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userlist = mapper.getUserLike("李");
        for (User user : userlist) {
            System.out.println(user);
        }

        sqlSession.close();
    }*/

    @Test
    public void test(){
        //第一步，获取SqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        try {
            //*推荐使用方式1*//*
            //方式1：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//获取UserDao对象
            List<User> userList = mapper.getUserList();
            //方式二：
           /* List<User> userList = sqlSession.selectList("com.xue.dao.UserMapper.getUserList");*/
            for (User user : userList) {
                System.out.println(user);
            }
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }
}
