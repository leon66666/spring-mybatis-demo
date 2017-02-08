package zhongqiu.spring_mybatis_demo.mapper;

import java.util.List;

import zhongqiu.spring_mybatis_demo.po.User;
import zhongqiu.spring_mybatis_demo.po.UserQueryVO;



public interface UserMapper {
	// 1、 根据用户ID查询用户信息
	public User findUserById(int id) throws Exception;

	// 3、 添加用户
	public void insertUser(User user) throws Exception;
	
	//综合查询
	public List<User> findUserList(UserQueryVO vo);
	
	//综合查询用户总数
	public int findUserCount(UserQueryVO vo);
	
	//resultMap入门
	public User findUserRstMap(int id);
}
