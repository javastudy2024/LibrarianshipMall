package com.ts.book.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private int orderID;  // 订单号
    private BigDecimal totalPrice;  // 订单总价
    private Date orderDate;  // 订单日期
    private String remarks;  // 备注
    private int userID;  // 用户ID


    public Order() {
    }

    public Order(int orderID, BigDecimal totalPrice, Date orderDate, String remarks, int userID) {
        this.orderID = orderID;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.remarks = remarks;
        this.userID = userID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
