package com.ts.book.dao;

import com.ts.book.domain.Order;
import com.ts.book.domain.OrderItem;

import java.util.List;

public interface OrderDAO {
    List<Order> findAllOrders();

    //  负责将订单信息和订单项信息保存到数据库中
    void saveOrder(Order order);
    void saveOrderItem(OrderItem orderItem);
}