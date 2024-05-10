package com.ts.book.service.Impl;

import com.ts.book.dao.BookDAO;
import com.ts.book.domain.Book;
import com.ts.book.service.SellerService;

public class SellerServiceImpl implements SellerService {
    private BookDAO bookDAO;

    public SellerServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    //  卖家:添加书籍
    @Override
    public void addBook(Book book) {
        //名称是为空
        if (book.getBookName() == null || book.getBookName().length() == 0) {
            System.out.println("名称为空");
            return;
        }
        //名称是否重复
        Book findBook = bookDAO.findBookByName(book.getBookName());
        if (findBook != null) {
            System.out.println("名称重复");
            return;
        }
        bookDAO.insertBook(book);
    }

}
