package com.ts.book.view;

import com.ts.book.controller.LoginController;

import java.util.Scanner;

public class WelcomeView {
    private Scanner scanner = new Scanner(System.in);

    LoginController loginController = new LoginController();

    public void displayMenu() {
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("欢迎登录商城系统");
            System.out.println("1. 登录");
            System.out.println("2. 注册");
            System.out.println("3. 充值");
            System.out.println("4. 退出");
            System.out.println("请选择你要进行的操作:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 读取换行符
            switch (choice) {
                case 1:
                    //  登录
                    int userType = login(); // 用户登录
                    if (userType != -1) { // 检查是否登录成功
                        loginController.navigateToUserInterface(userType); // 导航到相应用户界面
                    } else {
                        System.out.println("登录失败或用户选择退出。"); // 提供登录失败的反馈
                    }
                    break;
                case 2:
                    // 注册
                    loginController.register(scanner);
                    break;
                case 3:
                     // 充值
                    loginController.rechargeAccount(scanner);
                    break;
                case 4:
                    System.out.println("感谢您使用我们的系统，再见！");
                    continueLoop = false;
                    break;
                default:
                    System.out.println("无效的选项，请重新选择。");
            }
        }
    }

    private int login() {

        // 使用现有的控制器逻辑，已经包括三次尝试的处理
        LoginController loginController = new LoginController();
        return loginController.performLogin(scanner);
    }



    public static void main(String[] args) {
        WelcomeView welcomeView = new WelcomeView();
        welcomeView.displayMenu();
    }
}
