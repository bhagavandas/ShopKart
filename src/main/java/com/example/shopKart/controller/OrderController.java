package com.example.shopKart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopKart.model.Order;
import com.example.shopKart.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderService orders;

	public OrderController(OrderService orders) {
		this.orders = orders;
	}

	// POST /api/orders
	@PostMapping
	public ResponseEntity<Order> place(@RequestBody PlaceOrderRequest request) {
		Order order = orders.place(request.customerId(), request.items());
		return ResponseEntity.status(201).body(order);
	}

}
