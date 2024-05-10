package com.ts.book.dao.Impl;

import com.ts.book.dao.AdminDAO;
import com.ts.book.dao.DatabaseUtility;
import com.ts.book.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    //  添加功能
    //  根据用户名查找用户
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

    //  添加用户
    @Override
    public void addUser(User user) {
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


    //  删除功能
    //  删除用户
    @Override
    public boolean deleteUserById(int userID) {
        String sql = "DELETE FROM users WHERE UserID = ?";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //  通过用户ID查找用户
    @Override
    public User findUserById(int userID) {
        String sql = "SELECT * FROM users WHERE UserID = ?";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("password"));
                user.setBalance(rs.getBigDecimal("balance"));
                user.setPermissionID(rs.getInt("permissionID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //  修改功能
    //  修改用户
    @Override
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET Username = ?, password = ?, Balance = ?, PermissionID = ? WHERE UserID = ?";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setBigDecimal(3, user.getBalance());
            stmt.setInt(4, user.getPermissionID());
            stmt.setInt(5, user.getUserID());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }


    //  查询功能
    //  查询所有用户
    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try {
            Connection conn = DatabaseUtility.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("password"));
                user.setBalance(rs.getBigDecimal("balance"));
                user.setPermissionID(rs.getInt("permissionID"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
