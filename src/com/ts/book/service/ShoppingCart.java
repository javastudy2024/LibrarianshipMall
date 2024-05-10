package com.ts.book.service;

import com.ts.book.domain.Book;
import com.ts.book.domain.Order;
import com.ts.book.domain.OrderItem;
import com.ts.book.domain.OrderRelation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private Map<Book, Integer> items = new HashMap<>();

    public static void main(String[] args) {
         Map<Book, Integer> items = new HashMap<>();
        Book bok1 = new Book(1,"1", BigDecimal.ONE,1);
        Book bok2 = new Book(1,"1", BigDecimal.ONE,1);
        // book -> 2
        if (bok1.equals(bok2)) {
            System.out.println("eq");
        }
    }

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

    public void checkout(OrderService orderService,int userId) {
        if (!items.isEmpty()) {
            System.out.println("继续结账...");

            //创建订单
            Order order = orderService.createOrder(items, userId);
            //创建orderItem
            List<OrderItem> orderItems= orderService.createOrderItem(items);
            //创建orderRel
            List<OrderRelation> orderRel= orderService.createOrderRel(items);
            //插入数据库




            //修改用户balance
            //更新用户
            BigDecimal totalPrice = order.getTotalPrice();


            items.clear();
        } else {
            System.out.println("没有要结账的项目.");
        }
    }
}