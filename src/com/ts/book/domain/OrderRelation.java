package com.ts.book.domain;

public class OrderRelation {
    private int serialNumber;  // 序号
    private int orderID;  // 订单号
    private int itemID;  // 订单单项号

    public OrderRelation() {
    }

    public OrderRelation(int serialNumber, int orderID, int itemID) {
        this.serialNumber = serialNumber;
        this.orderID = orderID;
        this.itemID = itemID;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
}
