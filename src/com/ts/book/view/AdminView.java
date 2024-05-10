package com.ts.book.view;

import com.ts.book.controller.AdminController;
import com.ts.book.controller.SellerController;

import java.util.Scanner;

public class AdminView {

    private Scanner scanner = new Scanner(System.in);

    private AdminController adminController = new AdminController();

    public void displayMenu() {
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("欢迎登录商场管理员界面");
            System.out.println("1. 添加用户");
            System.out.println("2. 删除用户");
            System.out.println("3. 修改用户");
            System.out.println("4. 查看用户");
            System.out.println("5. 返回主界面");
            System.out.println("请选择你要进行的操作:");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 清除缓冲区的换行符

            switch (choice) {
                case 1:
                    adminController.addUser();
                    break;
                case 2:
                    adminController.deleteUser();
                    break;
                case 3:
                    adminController.updateUser();
                    break;
                case 4:
                    adminController.viewUsers();
                    break;
                case 5:
                    System.out.println("返回主界面...");
                    continueLoop = false;
                    break;
                default:
                    System.out.println("无效的选项，请重新选择。");
            }
        }
    }
}