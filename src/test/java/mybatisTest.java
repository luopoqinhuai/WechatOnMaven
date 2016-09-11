import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.reno.mybatis.MybatisUtils;
import com.reno.mybatis.domain.User;
import com.reno.mybatis.mapping.UserMapperI;

public class mybatisTest {

	
	public void testinsert() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		User user = new User();
		user.setName("中文测试");
		user.setAge(20);
		int add = mapper.add(user);
		sqlSession.commit();
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(add);

	}
	
	@Test
	public void testselect(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
		List<User> users=mapper.getAll();
		for(User u:users){
			System.out.println(u);
		}
	}

}
