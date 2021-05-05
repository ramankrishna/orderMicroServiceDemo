package com.demo.microservice.service;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.ordermicroservice.dao.BillingDAO;
import com.demo.ordermicroservice.dao.ItemDAO;
import com.demo.ordermicroservice.dao.OrderDAO;
import com.demo.ordermicroservice.dao.PaymentDAO;
import com.demo.ordermicroservice.dao.ShippingDAO;
import com.demo.ordermicroservice.db.model.Order;
import com.demo.ordermicroservice.service.OrderService;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
	
	@Mock
	public OrderDAO orderDAO;
	
	@Mock
	public ItemDAO itemDAO;
	
	@Mock
	public PaymentDAO paymentDAO;
	
	@Mock
	public ShippingDAO shippingDAO;
	
	@Mock
	public BillingDAO billingDAO;
	
	@InjectMocks
	public OrderService orderService;
	
	Map<String , Object> orderFields = new HashMap<>(); 
	
	
	@Test
	public void populateOrderValuesTest() {
		Order order = new Order();
		orderFields.put("order_status","Active");
		orderFields.put("order_customer_id", "222");
		orderFields.put("order_subtotal", "200$");
		order = orderService.populatingOrderValues(orderFields);
		assertNotNull(order);
	}

}
