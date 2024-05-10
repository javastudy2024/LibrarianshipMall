package com.ts.book.service.Impl;

import com.ts.book.dao.AdminDAO;
import com.ts.book.domain.User;
import com.ts.book.service.AdminService;

import java.math.BigDecimal;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private final AdminDAO adminDAO;

    public AdminServiceImpl(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    //  添加功能
    //  添加用户
    public boolean addUser(String username, String password) {
        if (adminDAO.findByUsername(username) != null) {
            System.out.println("用户名已存在，请重新输入用户名。");
            return false;
        }
        User newUser = new User();
        newUser.getUserID();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setBalance(BigDecimal.ZERO); // 设置默认金额为 0.0 元
        newUser.setPermissionID(3); // 默认为买家权限
        adminDAO.addUser(newUser);
        return true;
    }

    //  删除功能
    //  删除用户
    @Override
    public boolean deleteUserById(int userID) {
        User user = adminDAO.findUserById(userID);
        if (user == null) {
            System.out.println("用户编号不存在，无法删除。");
            return false;
        }
        return adminDAO.deleteUserById(userID);
    }

    @Override
    public User findUserById(int userId) {
        return adminDAO.findUserById(userId);
    }

    //  修改功能
    //  修改用户信息
    @Override
    public boolean updateUser(User user) {
        return adminDAO.updateUser(user);
    }


    @Override
    public List<User> getAllUsers() {
        return adminDAO.findAllUsers();
    }
}


