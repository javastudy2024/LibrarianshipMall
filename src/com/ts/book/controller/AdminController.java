package com.ts.book.controller;

import com.ts.book.dao.Impl.AdminDAOImpl;
import com.ts.book.domain.User;
import com.ts.book.service.AdminService;
import com.ts.book.service.Impl.AdminServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class AdminController {
    private Scanner scanner = new Scanner(System.in);

    private AdminService adminService;

    public AdminController() {
        this.adminService = new AdminServiceImpl(new AdminDAOImpl());
    }

    //  添加功能
    //  添加用户
    public void addUser() {
        System.out.print("请输入用户名: ");
        String username = scanner.nextLine();
        System.out.print("请输入密码: ");
        String password = scanner.nextLine();
        if (adminService.addUser(username, password)) {
            System.out.println("新用户添加成功。");
        } else {
            System.out.println("用户名已存在，请尝试其他用户名。");
        }
        adminService.addUser(username, password);
    }


    //  删除功能
    //  删除用户
    public void deleteUser() {
        System.out.print("请输入要删除的用户编号: ");
        int userId = scanner.nextInt();
        if (adminService.deleteUserById(userId)) {
            System.out.println("用户删除成功。");
        } else {
            System.out.println("删除失败。");
        }
    }



    //  修改功能
    //  修改用户信息
    public void updateUser() {
        List<User> users = adminService.getAllUsers();
        users.forEach(user -> System.out.println("用户编号: " + user.getUserID()
                + ", 用户名称: " + user.getUsername()));
        // zhangsan
        // lisi ->zhangsan
        System.out.print("请输入要修改的用户ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // 清除输入缓冲
        System.out.print("请输入新的用户名: ");
        String username = scanner.nextLine();
        System.out.print("请输入新的密码: ");
        String password = scanner.nextLine();
        System.out.print("请输入新的金额: ");
        BigDecimal balance = scanner.nextBigDecimal();
        System.out.print("请输入新的权限: ");
        int permissionID = scanner.nextInt();

        User user = new User(id, username, password, balance, permissionID);
        if (adminService.updateUser(user)) {
            System.out.println("用户信息已成功更新。");
        } else {
            System.out.println("更新失败，用户可能不存在。");
        }
    }

    //  查看所有用户
    public void viewUsers() {
        List<User> users = adminService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("目前没有注册用户。");
        } else {
            users.forEach(user ->
                    System.out.println("用户编号: " + user.getUserID()
                            + ", 用户名称: " + user.getUsername()
                            + ", 登录密码: " + user.getPassword()
                            + ", 金额: " + user.getBalance()
                            + ", 权限号: " + user.getPermissionID()));
        }
    }
}