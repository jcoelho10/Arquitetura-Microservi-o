package com.example.orderservice.service;

import java.util.List;

import com.example.orderservice.model.Order;

public interface OrderService {

	List<Order> getAllOrders();
	Order createOrder(Order order);
}
