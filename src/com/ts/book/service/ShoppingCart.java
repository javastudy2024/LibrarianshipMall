package com.ts.book.service;

import com.ts.book.domain.Book;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Book, Integer> items = new HashMap<>();

    // 添加书籍到购物车
    public void addBook(Book book, int quantity) {
        if (items.containsKey(book)) {
            items.put(book, items.get(book) + quantity);
        } else {
            items.put(book, quantity);
        }
    }

    public Map<Book, Integer> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("购物车为空.");
        } else {
            items.forEach((book, quantity) -> System.out.println(book + " 数量: " + quantity));
        }
    }

    public void checkout(OrderService orderService) {
        if (!items.isEmpty()) {
            System.out.println("继续结账...");
            orderService.createOrder(items);  // 假设这个方法在 OrderService 中定义
            items.clear();
        } else {
            System.out.println("没有要结账的项目.");
        }
    }
}