package com.ts.book.view;

import com.ts.book.controller.SellerController;

import java.util.Scanner;

public class SellerView {
    public static void main(String[] args) {
        SellerView sellerView = new SellerView();
        sellerView.displayMenu();
    }

    private Scanner scanner = new Scanner(System.in);

    private SellerController sellerController = new SellerController();

    public void displayMenu() {
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("欢迎登录商场卖家界面");
            System.out.println("1. 添加书籍");
            System.out.println("2. 删除书籍");
            System.out.println("3. 修改书籍");
            System.out.println("4. 查看书籍");
            System.out.println("5. 返回主界面");
            System.out.println("请选择你要进行的操作:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sellerController.addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    viewBooks();
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


    private void deleteBook() {
        // 删除书籍功能的实现
        System.out.println("删除书籍功能待实现...");
    }

    private void updateBook() {
        // 修改书籍功能的实现
        System.out.println("修改书籍功能待实现...");
    }

    private void viewBooks() {
        // 查看书籍功能的实现
        System.out.println("查看书籍功能待实现...");
    }
}