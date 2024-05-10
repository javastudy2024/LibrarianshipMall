package com.ts.book.service.Impl;

import com.ts.book.dao.BookDAO;
import com.ts.book.domain.Book;
import com.ts.book.service.BookService;
import com.ts.book.service.ShoppingCart;

import java.util.List;

public class BookServiceImpl implements BookService {
    private final BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    //  查询所有书籍
    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findAllBooks();
    }

    //  购买书籍
    //  通过书籍编号查询书籍
    @Override
    public Book findBookById(int bookId) {
        return bookDAO.findBookById(bookId);
    }

    @Override
    public boolean purchaseBookById(int bookId, int quantity) {
        Book book = bookDAO.findBookById(bookId);
        if (book != null && book.getStockQuantity() >= quantity) {
            bookDAO.updateBookStock(bookId, quantity);
            return true;
        }
        return false;
    }

    //  通过书籍名称查询书籍
    @Override
    public Book findBookByName(String bookName) {
        return bookDAO.findBookByName(bookName);
    }

    @Override
    public boolean purchaseBookByName(String bookName, int quantity) {
        Book book = bookDAO.findBookByName(bookName);
        if (book != null && book.getStockQuantity() >= quantity) {
            bookDAO.updateBookStock(book.getBookID(), quantity);
            return true;
        }
        return false;
    }

    //  买家: 购买书籍
    @Override
    public void purchaseBook(int bookId, int quantity) {
        // 此处应有购买逻辑，假设简化为直接输出
        System.out.println("Purchased book ID " + bookId + " with quantity " + quantity);
    }
}