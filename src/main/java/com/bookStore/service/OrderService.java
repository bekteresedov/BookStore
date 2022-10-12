package com.bookStore.service;

import com.bookStore.data.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order>getAllOrders();

    public Order putAnOrder(List<Integer > bookIdList, String userName);
}
