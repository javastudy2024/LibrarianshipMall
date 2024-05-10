package com.ts.book.controller;

import com.ts.book.dao.Impl.BookDAOImpl;
import com.ts.book.domain.Book;
import com.ts.book.service.Impl.SellerServiceImpl;
import com.ts.book.service.SellerService;

import java.math.BigDecimal;
import java.util.Scanner;

public class SellerController {
    private SellerService service;

    public SellerController() {
        this.service = new SellerServiceImpl(new BookDAOImpl());
    }

    public void addBook() {
        //菜单
        String bookName;
        BigDecimal price;
        int stock;

        Scanner sc = new Scanner(System.in);
        System.out.println("书籍名");
        bookName = sc.nextLine();

        System.out.println("价格");
        String priceStr = sc.nextLine();
        price = new BigDecimal(priceStr);

        System.out.println("书籍库存");
        stock = sc.nextInt();
        Book book = new Book(bookName, price, stock);

        service.addBook(book);
    }


}
