package com.ts.book.service.Impl;

import com.ts.book.domain.Book;
import com.ts.book.dao.OrderDAO;
import com.ts.book.domain.Order;
import com.ts.book.domain.OrderRelation;
import com.ts.book.service.OrderService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order createOrder(Map<Book, Integer> items, int userId) {
        Order order=new Order();

        order.setTotalPrice(createPrice(items));
        order.setOrderDate(new Date());
        order.setUserID(userId);

        System.out.println("为项目创建订单: " + items);
        return order;
    }


    public BigDecimal createPrice(Map<Book, Integer> items){
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            BigDecimal unitPrice = entry.getKey().getUnitPrice();
            Integer number = entry.getValue();
            totalPrice.add(unitPrice.multiply(BigDecimal.valueOf(number)));
        }
        return totalPrice;
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