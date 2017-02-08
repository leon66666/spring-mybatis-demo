package zhongqiu.spring_mybatis_demo.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhongqiu.spring_mybatis_demo.mapper.UserMapper;
import zhongqiu.spring_mybatis_demo.po.User;

public class UserMapperTest {

	private ApplicationContext ctx;

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
	}


	@Test
	public void testFindUserById() throws Exception{
		UserMapper mapper = (UserMapper) ctx.getBean("userMapper");
		
		User user =mapper.findUserById(1);
		
		System.out.println(user);
	}
}
