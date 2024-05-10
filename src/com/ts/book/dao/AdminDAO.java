package com.ts.book.dao;

import com.ts.book.domain.User;

import java.util.List;

public interface AdminDAO {

    //  添加功能
    //  根据用户名查找用户
    User findByUsername(String username);
    //  添加用户
    void addUser(User user);

    //  删除功能
    //  删除用户
    boolean deleteUserById(int userId);
    //  根据用户编号查找用户
    User findUserById(int userID);


    //  修改功能
    //  修改用户信息
    boolean updateUser(User user);

    //  查看所有用户
    List<User> findAllUsers();


}
