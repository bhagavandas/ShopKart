package com.example.shopKart.controller;

import java.util.List;

import com.example.shopKart.model.OrderItem;

public record PlaceOrderRequest(Long customerId, List<OrderItem> items) {

}
