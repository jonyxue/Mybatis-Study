import com.xue.dao.UserMapper;
import com.xue.pojo.User;
import com.xue.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> getusers = mapper.getusers();
        for (User getuser : getusers) {
            System.out.println(getuser);

        }
        sqlSession.close();
    }
    @Test
    public  void update(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.update(new User(7,"张三丰","568"));

        sqlSession.commit();
        sqlSession.close();

    }
}
