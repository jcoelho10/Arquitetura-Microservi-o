package com.example.orderservice.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.example.orderservice.model.Order;
import com.example.orderservice.order.OrderServiceApplication;
import com.example.orderservice.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServiceApplication.class)
public class OrderControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OrderService orderService;
	
	@MockBean
	private RestTemplate restTemplate;
	
	@Test
	public void testetAllOrders() throws Exception {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order("1", "Order1"));
		orders.add(new Order("2", "Order2"));
		
		when(orderService.getAllOrders()).thenReturn(orders);
		
		mockMvc.perform(get("/orders"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].name").value("Order1"))
			.andExpect(jsonPath("$[1].name").value("Order2"));
	}
	
	@Test
	public void testCreateOrder() throws Exception {
		Order order = new Order("2", "New Order");
		
		when(orderService.createOrder(any(Order.class))).thenReturn(order);
		
		mockMvc.perform(post("/orders")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\":1,\"name\":\"New Order\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("New Order"));
	}
	
	@Test
	public void testGetDados() throws Exception {
		String url = "http://exemplo.com/api/dados";
		String expectedResponse = "Resposta mockada";
		
		when(restTemplate.getForEntity(url, String.class)).thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));
		
		
		mockMvc.perform(get("/orders/dados"))
			.andExpect(status().isOk())
			.andExpect(content().string(expectedResponse));
	}

}
