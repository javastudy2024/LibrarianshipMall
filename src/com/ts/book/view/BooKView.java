package com.ts.book.view;

import com.ts.book.domain.Book;

import java.util.List;

public class BooKView {

    public static void showBook(List<Book> books) {
        System.out.println("现有书籍:");
        for (Book book : books) {
            System.out.printf("书籍编号: %d, 书籍名称: %s, 单价: %.2f, 库存量: %d\n",
                    book.getBookID(), book.getBookName(), book.getUnitPrice(), book.getStockQuantity());
        }
    }
}
