package com.ts.book.dao;

import com.ts.book.domain.User;

import java.math.BigDecimal;

public interface UserDAO {

    //  登录功能
    //  根据用户名和密码查找用户
    User findByUsernameAndPassword(String username, String password);

    //  注册功能
    //  根据用户名查找用户
    User findByUsername(String username);
    //  保存用户
    void save(User user);

    //  充值功能
    // 更新余额的方法
    void updateBalance(String username, BigDecimal amount);
    //  查看余额的方法
    BigDecimal findBalanceByUserId(int userID);
}
