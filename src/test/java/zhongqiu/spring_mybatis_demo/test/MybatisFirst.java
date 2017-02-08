package zhongqiu.spring_mybatis_demo.test;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import zhongqiu.spring_mybatis_demo.po.User;


public class MybatisFirst {
	@Test
	public void findUserByIdTest() throws Exception{
		//读取配置文件
		//全局配置文件的路径
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//调用SqlSession的增删改查方法
		//第一个参数：表示statement的唯一标示
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		
		//关闭资源
		sqlSession.close();
	}
	
	@Test
	public void findUsersByNameTest() throws Exception{
		//读取配置文件
		//全局配置文件的路径
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//调用SqlSession的增删改查方法
		//第一个参数：表示statement的唯一标示
		List<User> list = sqlSession.selectList("test.findUsersByName", "小明");
		System.out.println(list);
		//关闭资源
		sqlSession.close();
	}
	
	@Test
	public void insertUserTest() throws Exception{
		//读取配置文件
		//全局配置文件的路径
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//创建SqlSession。opensession方式会自动开启事务，默认是不自动提交事务，需要手动conmit。设置opensession（true），可以自动提交事务
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("东哥hm19");
		user.setAddress("宝盛西里24号楼");
		
		//调用SqlSession的增删改查方法
		//第一个参数：表示statement的唯一标示
		sqlSession.insert("test.insertUser", user);
		
		System.out.println(user.getId());
		//提交事务
		sqlSession.commit();
		//关闭资源
		sqlSession.close();
	}
	
	public void add(User user){
		user.setId(2);
	}
	public void main(){
		int a = 1;
		User user = new User();
		user.setId(1);
		add(user);
		System.out.println(user.getId());
	}
	
}
