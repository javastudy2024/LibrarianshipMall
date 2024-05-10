package com.ts.book.domain;

import java.math.BigDecimal;

public class OrderItem {
    private int itemID;  // 商品编号
    private String itemName;  // 商品名称
    private int quantity;  // 购买数量
    private BigDecimal unitPrice;  // 商品单价
    private BigDecimal totalPrice;  // 总价


    public OrderItem() {
    }

    public OrderItem(int itemID, String itemName, int quantity, BigDecimal unitPrice, BigDecimal totalPrice) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
