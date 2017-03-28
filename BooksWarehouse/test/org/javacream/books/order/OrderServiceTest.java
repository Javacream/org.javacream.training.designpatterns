package org.javacream.books.order;

import org.javacream.application.ApplicationContext;
import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderServiceTest {

	private OrderService orderService;

	@Before public void init(){
		orderService =ApplicationContext.orderService();
	}
	
	
	@Test public void createOrderOk(){
		Order order = orderService.order("ISBN2", 20);
		//Assert.assertTrue(order.getStatus() == OrderStatus.OK); //Impossible to test using CustomStoreServiceAdapter
		Assert.assertNotNull(order);
		Assert.assertNotEquals(order.getStatus(), Order.OrderStatus.UNACCEPTABLE);
		
	}
	@Test public void createOrderPending(){
		Order order = orderService.order("ISBN2", 100);
		Assert.assertTrue(order.getStatus() == OrderStatus.PENDING);
	}
	
	@Test public void createOrderUnavailable(){
		Order order = orderService.order("##ISBN2##", 20);
		Assert.assertTrue(order.getStatus() == OrderStatus.UNACCEPTABLE);
	}

}
