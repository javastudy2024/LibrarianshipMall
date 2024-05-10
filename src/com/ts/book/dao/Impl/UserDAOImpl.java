package com.ts.book.dao.Impl;

import com.ts.book.dao.DatabaseUtility;
import com.ts.book.dao.UserDAO;
import com.ts.book.domain.User;

import java.math.BigDecimal;
import java.sql.*;

public class UserDAOImpl implements UserDAO {

    // 登录功能
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        String sql = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setBalance(rs.getBigDecimal("Balance"));
                user.setPermissionID(rs.getInt("PermissionID"));
            }
        } catch (SQLException e) {
            System.out.println("数据库查询异常: " + e.getMessage());
        }
        return user;
    }

    //  注册功能
    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE Username = ?";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapToUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (Username, Password, Balance, PermissionID) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setBigDecimal(3, user.getBalance());
            stmt.setInt(4, user.getPermissionID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private User mapToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserID(rs.getInt("UserID"));
        user.setUsername(rs.getString("Username"));
        user.setPassword(rs.getString("Password"));
        user.setBalance(rs.getBigDecimal("Balance"));
        user.setPermissionID(rs.getInt("PermissionID"));
        return user;
    }

    //  充值功能
    @Override
    public void updateBalance(String username, BigDecimal amount) {
        String sql = "UPDATE users SET Balance = Balance + ? WHERE Username = ?";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBigDecimal(1, amount);
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  查看余额的方法
    @Override
    public BigDecimal findBalanceByUserId(int userID) {
        String sql = "SELECT balance FROM users WHERE UserID = ?";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getBigDecimal("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }
}