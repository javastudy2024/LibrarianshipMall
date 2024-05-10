package com.ts.book.service;

import com.ts.book.domain.User;

import java.math.BigDecimal;

public interface UserService {
    //  登录功能
    User login(String username, String password);

    //  注册功能
    boolean register(String username, String password);

    //  充值功能
    boolean recharge(String username, BigDecimal amount);

    //  查看余额的方法
    BigDecimal getUserBalance(int userID);

}
