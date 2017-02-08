package zhongqiu.spring_mybatis_demo.mapper;

import java.util.List;

import zhongqiu.spring_mybatis_demo.po.OrdersExt;
import zhongqiu.spring_mybatis_demo.po.User;

public interface OrdersMapper {
	//一对一之resultType
	public List<OrdersExt> findOrdersAndUser();
	
	//一对一之resultMap
	public List<OrdersExt> findOrdersAndUserRstMap();
	
	//一对多
	public List<OrdersExt> findOrdersAndDetailRstMap();
	
	//多对多
	public List<User> findUserAndItemsRstMap();
	
	//延迟加载
	public List<OrdersExt> findOrderAndUserLazyLoading();
}
