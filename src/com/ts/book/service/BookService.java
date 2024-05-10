package com.ts.book.service;

import com.ts.book.domain.Book;

import java.util.List;

public interface BookService {

    //  查询所有书籍
    List<Book> getAllBooks();
    //  买家: 购买书籍
    void purchaseBook(int bookId, int quantity);

    //  购买书籍
    //  通过书籍编号查询书籍
    Book findBookById(int bookId);
    boolean purchaseBookById(int bookId, int quantity);
    //  通过书籍名称查询书籍
    Book findBookByName(String bookName);
    boolean purchaseBookByName(String bookName, int quantity);

}