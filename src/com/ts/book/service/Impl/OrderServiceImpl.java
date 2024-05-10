package com.ts.book.service.Impl;

import com.ts.book.domain.Book;
import com.ts.book.dao.OrderDAO;
import com.ts.book.domain.Order;
import com.ts.book.service.OrderService;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void createOrder(Map<Book, Integer> items) {
        System.out.println("为项目创建订单: " + items);
    }

    public void displayOrders() {
        System.out.println("显示所有订单...");
    }

    //  查询所有订单
    @Override
    public List<Order> getAllOrders() {
        return orderDAO.findAllOrders();
    }


}