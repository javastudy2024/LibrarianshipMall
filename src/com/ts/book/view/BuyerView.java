package com.ts.book.view;

import com.ts.book.controller.BuyerController;

import java.util.ArrayList;
import java.util.Scanner;

public class BuyerView {

    private Scanner scanner = new Scanner(System.in);

    BuyerController buyerController = new BuyerController();

    public void displayMenu() {
        buyerController.displayBooks();
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("\n欢迎进入买家页面");
            System.out.println("1. 购买书籍");
            System.out.println("2. 进入购物车");
            System.out.println("3. 查询所有订单信息");
            System.out.println("4. 退出");
            System.out.print("请选择操作：");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    buyerController.initiatePurchase();
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    keepRunning = false;
                    System.out.println("退出成功！");
                    break;
                default:
                    System.out.println("无效选项，请重新选择。");
            }
        }
    }
}