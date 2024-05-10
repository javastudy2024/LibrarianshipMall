package com.ts.book.controller;

import com.ts.book.dao.Impl.BookDAOImpl;
import com.ts.book.dao.Impl.OrderDAOImpl;
import com.ts.book.dao.Impl.UserDAOImpl;
import com.ts.book.domain.Book;
import com.ts.book.domain.Order;
import com.ts.book.service.BookService;
import com.ts.book.service.Impl.BookServiceImpl;
import com.ts.book.service.Impl.OrderServiceImpl;
import com.ts.book.service.Impl.UserServiceImpl;
import com.ts.book.service.OrderService;
import com.ts.book.service.ShoppingCart;
import com.ts.book.service.UserService;
import com.ts.book.view.BooKView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BuyerController {
    private final BookService bookService;
    private final Scanner scanner;
    private final ShoppingCart shoppingCart;
    private final OrderService orderService;
    private final UserService userService;

    public BuyerController() {
        this.bookService = new BookServiceImpl(new BookDAOImpl());
        this.scanner = new Scanner(System.in);
        this.shoppingCart = new ShoppingCart();
        this.orderService = new OrderServiceImpl(new OrderDAOImpl());
        this.userService = new UserServiceImpl(new UserDAOImpl());
    }

    //  显示所有书籍
    public void displayBooks() {
        //业务逻辑
        List<Book> books = bookService.getAllBooks();

        //渲染视图 VIEW
        BooKView.showBook(books);

    }

    //  账户余额
    public void displayUserBalance(int userID) {
        BigDecimal balance = userService.getUserBalance(userID);
        System.out.println("您的账户余额为: " + balance);
    }

    //  购买书籍
    public void initiatePurchase() {
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("输入 1 通过书籍编号购买，输入 2 通过书籍名称购买, 输入 0 返回主菜单:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符，避免输入问题

            switch (choice) {
                case 1:
                    buyBookById();
                    break;
                case 2:
                    buyBookByName();
                    break;
                case 0:
                    continueLoop = false;
                    break;
                default:
                    System.out.println("无效的输入，请重新输入。");
            }
        }
    }

    private void buyBookById() {
        System.out.println("请输入书籍编号:");
        int bookId = scanner.nextInt();
        Book book = bookService.findBookById(bookId);

        if (book != null) {
            System.out.println("请输入购买数量:");
            int quantity = scanner.nextInt();

            if (quantity > book.getStockQuantity()) {
                System.out.println("库存不足! 当前库存: " + book.getStockQuantity());
                if (!askIfContinue()) return;
            } else if (quantity <= book.getStockQuantity()) {
                shoppingCart.addBook(book, quantity);
                System.out.println("已将 " + book.getBookName() + " 添加到购物车。");
            } else {
                System.out.println("购买失败，发生未知错误。");
                if (!askIfContinue()) return;
            }
        } else {
            System.out.println("书籍编号不存在，请重新输入。");
            if (!askIfContinue()) return;
        }
    }

    private void buyBookByName() {
        System.out.println("请输入书籍名称:");
        String bookName = scanner.nextLine();
        Book book = bookService.findBookByName(bookName);

        if (book != null) {
            System.out.println("请输入购买数量:");
            int quantity = scanner.nextInt();

            if (quantity > book.getStockQuantity()) {
                System.out.println("库存不足!" + book.getStockQuantity());
                if (!askIfContinue()) return;
            } else if (quantity <= book.getStockQuantity()) {
                shoppingCart.addBook(book, quantity);
                System.out.println("已将 " + book.getBookName() + " 添加到购物车。");
            } else {
                System.out.println("购买失败，可能是库存问题。");
                if (!askIfContinue()) return;
            }
        } else {
            System.out.println("书籍名称不存在，请重新输入。");
            if (!askIfContinue()) return;
        }
    }

    private boolean askIfContinue() {
        System.out.println("继续当前操作请按 1，返回主菜单请按 0:");
        int choice = scanner.nextInt();
        return choice != 0;
    }

    //  显示购物车
    public void displayBooksAndHandlePurchases() {
        List<Book> books = bookService.getAllBooks(); // 显示书籍并获取书籍列表
        // 假设用户交互选择书籍和数量，这里直接使用示例 ID 和数量
        bookService.purchaseBook(1, 1); // 示例购买
    }

    public void handleCartOperations(int userId) {
        shoppingCart.displayCart(); // 显示购物车内容

        shoppingCart.checkout(orderService, userId); // 结账
    }

    public void displayAllOrders() {
        orderService.displayOrders(); // 显示所有订单信息
    }
}