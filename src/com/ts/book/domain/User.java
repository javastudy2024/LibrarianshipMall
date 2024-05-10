package com.ts.book.domain;

import java.math.BigDecimal;

public class User {
    private int userID;  // 用户编号

    private String username;  // 用户名称

    private String password;  // 登录密码

    private BigDecimal balance;  // 金额

    private int permissionID;  // 权限号

    public User() {
    }

    public User(int userID, String username, String password, BigDecimal balance, int permissionID) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.permissionID = permissionID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(int permissionID) {
        this.permissionID = permissionID;
    }
}
