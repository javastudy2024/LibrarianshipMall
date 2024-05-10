package com.ts.book.dao.Impl;

import com.ts.book.dao.BookDAO;
import com.ts.book.dao.DatabaseUtility;
import com.ts.book.domain.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {


    //  查询所有书籍
    @Override
    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookID(rs.getInt("BookID"));
                book.setBookName(rs.getString("BookName"));
                book.setUnitPrice(rs.getBigDecimal("UnitPrice"));
                book.setStockQuantity(rs.getInt("StockQuantity"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    //  购买书籍
    //  通过书籍编号查询书籍
    @Override
    public Book findBookById(int bookId) {
        String sql = "SELECT * FROM books WHERE BookID = ?";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Book(rs.getInt("BookID"),
                        rs.getString("BookName"),
                        rs.getBigDecimal("UnitPrice"),
                        rs.getInt("StockQuantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //  通过书籍名称查询书籍
    @Override
    public Book findBookByName(String bookName) {
        String sql = "SELECT * FROM books WHERE BookName = ?";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bookName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Book(rs.getInt("BookID"),
                        rs.getString("BookName"),
                        rs.getBigDecimal("UnitPrice"),
                        rs.getInt("StockQuantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //  更新书籍库存
    @Override
    public void updateBookStock(int bookId, int quantity) {
        String sql = "UPDATE books SET StockQuantity = StockQuantity - ? WHERE BookID = ?";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, bookId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //  卖家:添加书籍
    @Override
    public void insertBook(Book book) {
        String sql = "INSERT INTO Books ( BookName, UnitPrice, StockQuantity) VALUES(?, ?, ?)";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, book.getBookName());
            stmt.setBigDecimal(2, book.getUnitPrice());
            stmt.setInt(3, book.getStockQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}