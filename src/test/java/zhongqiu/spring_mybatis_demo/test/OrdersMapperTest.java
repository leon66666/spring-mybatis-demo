package zhongqiu.spring_mybatis_demo.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhongqiu.spring_mybatis_demo.mapper.OrdersMapper;
import zhongqiu.spring_mybatis_demo.po.OrdersExt;
import zhongqiu.spring_mybatis_demo.po.User;

public class OrdersMapperTest {

	private ApplicationContext ctx;

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
	}

	@Test
	public void testFindOrdersAndUser() {
		
		OrdersMapper mapper = (OrdersMapper)ctx.getBean("ordersMapper");

		List<OrdersExt> list = mapper.findOrdersAndUser();
		
	}

	@Test
	public void testFindOrdersAndUserRstMap() {
		OrdersMapper mapper = (OrdersMapper)ctx.getBean("ordersMapper"); 

		List<OrdersExt> list = mapper.findOrdersAndUserRstMap();
	}

	@Test
	public void testFindOrdersAndDetailRstMap() {
		OrdersMapper mapper = (OrdersMapper)ctx.getBean("ordersMapper"); 

		List<OrdersExt> list = mapper.findOrdersAndDetailRstMap();
	}

	@Test
	public void testFindUserAndItemsRstMap() {
		OrdersMapper mapper = (OrdersMapper)ctx.getBean("ordersMapper"); 

		List<User> list = mapper.findUserAndItemsRstMap();

	}

	@Test
	public void testLazyLoading() {
		OrdersMapper mapper = (OrdersMapper)ctx.getBean("ordersMapper"); 

		List<OrdersExt> list = mapper.findOrderAndUserLazyLoading();

		for (OrdersExt order : list) {
			System.out.println(order.getUser());
		}

	}
}
