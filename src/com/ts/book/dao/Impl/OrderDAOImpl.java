package com.ts.book.dao.Impl;

import com.ts.book.dao.DatabaseUtility;
import com.ts.book.dao.OrderDAO;
import com.ts.book.domain.Order;
import com.ts.book.domain.OrderItem;
import com.ts.book.service.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    //  查询所有订单
    @Override
    public List<Order> findAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM Orders";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                order.setTotalPrice(rs.getBigDecimal("TotalPrice"));
                order.setOrderDate(rs.getDate("OrderDate"));
                order.setRemarks(rs.getString("Remarks"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    //  创建订单
    public void createOrder(ShoppingCart cart, int userId) {
        // 创建新订单和订单项
    }

    //  保存订单
    @Override
    public void saveOrder(Order order) {
        // JDBC code to save order to the database
        System.out.println("已保存订单");
    }

    //  保存订单项
    @Override
    public void saveOrderItem(OrderItem orderItem) {
        // JDBC code to save order item to the database
        System.out.println("保存的订单项目");
    }
}