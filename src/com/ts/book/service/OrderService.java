package com.ts.book.service;

import com.ts.book.domain.Book;
import com.ts.book.domain.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Order> getAllOrders();

    Order createOrder(Map<Book, Integer> items,int userId);
    void displayOrders();
}