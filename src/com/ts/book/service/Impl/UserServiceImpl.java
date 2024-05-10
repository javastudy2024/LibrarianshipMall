package com.ts.book.service.Impl;

import com.ts.book.dao.UserDAO;
import com.ts.book.domain.User;
import com.ts.book.service.UserService;

import java.math.BigDecimal;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //  登录功能
    @Override
    public User login(String username, String password) {
        return userDAO.findByUsernameAndPassword(username, password);
    }

    //  注册功能
    @Override
    public boolean register(String username, String password) {
        if (userDAO.findByUsername(username) != null) {
            System.out.println("该用户名已存在。");
            return false;
        }

        User newUser = new User();
        newUser.getUserID();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setBalance(BigDecimal.ZERO); // 设置默认金额为 0.0 元
        newUser.setPermissionID(3); // 默认为买家权限
        userDAO.save(newUser);
        return true;
    }

    //  充值功能
    @Override
    public boolean recharge(String username, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("充值金额必须大于零。");
            return false;
        }
        userDAO.updateBalance(username, amount);
        return true;
    }

    //  查看余额的方法
    @Override
    public BigDecimal getUserBalance(int userID) {
        return userDAO.findBalanceByUserId(userID);
    }
}
