package com.ts.book.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Book {
    private int bookID;  // 书籍编号

    private String bookName;  // 书籍名称

    private BigDecimal unitPrice;  // 单价

    private int stockQuantity;  // 库存量

    public Book() {
    }

    public Book(int bookID, String bookName, BigDecimal unitPrice, int stockQuantity) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }

    public Book(String bookName, BigDecimal unitPrice, int stockQuantity) {
        this.bookName = bookName;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookID == book.bookID && stockQuantity == book.stockQuantity && Objects.equals(bookName, book.bookName) && Objects.equals(unitPrice, book.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID, bookName, unitPrice, stockQuantity);
    }
}
