package com.ts.book.service;

import com.ts.book.dao.AdminDAO;
import com.ts.book.dao.UserDAO;
import com.ts.book.domain.User;

import java.util.List;

public interface AdminService {

        //  添加功能
        //  添加用户
        boolean addUser(String username, String password);


        //  删除功能
        //  删除用户
        boolean deleteUserById(int userId);

        //  修改用户信息
        boolean updateUser(User user);
        //  根据用户编号查找用户
        User findUserById(int userId);

        //  查看所有用户
        List<User> getAllUsers();

}
