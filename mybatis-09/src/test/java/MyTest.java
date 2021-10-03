import com.xue.dao.UserMapper;
import com.xue.pojo.User;
import com.xue.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);

        System.out.println("************");

        User user1 = mapper.queryUserById(1);
        System.out.println(user1);
        System.out.println(user==user1);
        sqlSession.close();
    }
}
