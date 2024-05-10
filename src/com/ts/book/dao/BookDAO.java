package com.ts.book.dao;

import com.ts.book.domain.Book;
import java.util.List;

public interface BookDAO {

    //  查询所有书籍
    List<Book> findAllBooks();

    //  购买书籍
    Book findBookById(int bookId);
    Book findBookByName(String bookName);
    void updateBookStock(int bookId, int quantity);

    //  卖家:添加书籍
    void insertBook(Book book);
}
