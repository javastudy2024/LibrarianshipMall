package com.ts.book.controller;

import com.ts.book.dao.Impl.UserDAOImpl;
import com.ts.book.domain.User;
import com.ts.book.service.Impl.UserServiceImpl;
import com.ts.book.service.UserService;
import com.ts.book.view.AdminView;
import com.ts.book.view.BuyerView;
import com.ts.book.view.SellerView;

import java.math.BigDecimal;
import java.util.Scanner;

public class LoginController {
    private final UserService userService;

    public LoginController() {
        this.userService = new UserServiceImpl(new UserDAOImpl());
    }

    //  登录功能
    public int performLogin(Scanner scanner) {
        int attempts = 0;
        while (attempts < 3) {  // 最多允许三次尝试登录
            System.out.println("请输入用户名:");
            String username = scanner.nextLine();
            System.out.println("请输入密码:");
            String password = scanner.nextLine();
            //scanner.nextLine(); // 读取换行符
            User user = userService.login(username, password); // 调用服务层来验证用户
            if (user != null) {
                return user.getPermissionID(); // 返回用户权限编号，表示登录成功
            } else {
                System.out.println("登录失败，请重新尝试。");
                System.out.println("输入次数还有:" + (3 - attempts - 1));
                attempts++;
            }
        }
        System.out.println("三次登录失败，返回主界面。");
        return -1;  // 返回-1表示登录失败
    }

//    public int smsLogin(Scanner scanner) {
//        System.out.println("请输入手机号:");
//        String phone = scanner.nextLine();
//        System.out.println("发送短信中.....");
//
//        //生成验证码
//        int sysCode = getRandomCode();
//
//        //发短信
//        sendMessage(phone, sysCode);
//
//        //比较
//        System.out.println("输入验证码");
//        int code = scanner.nextInt();
//
//        if (code != sysCode) {
//            System.out.println("验证码错误");
//            return 0;
//        }
//        return 1;
//    }
//
//    private int getRandomCode() {
//        return 123456;
//    }
//
//    private void sendMessage(String phone, int code) {
        //发送短信
//        java.util.List<String> args = java.util.Arrays.asList(args_);
//        com.aliyun.dysmsapi20170525.Client client = Sample.createClient();
//        com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
//                .setPhoneNumbers("your_value")
//                .setSignName(sysCode);
//        try {
//            // 复制代码运行请自行打印 API 的返回值
//            client.sendSmsWithOptions(sendSmsRequest, new com.aliyun.teautil.models.RuntimeOptions());
//        } catch (TeaException error) {
//            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
//            // 错误 message
//            System.out.println(error.getMessage());
//            // 诊断地址
//            System.out.println(error.getData().get("Recommend"));
//            com.aliyun.teautil.Common.assertAsString(error.message);
//        } catch (Exception _error) {
//            TeaException error = new TeaException(_error.getMessage(), _error);
//            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
//            // 错误 message
//            System.out.println(error.getMessage());
//            // 诊断地址
//            System.out.println(error.getData().get("Recommend"));
//            com.aliyun.teautil.Common.assertAsString(error.message);
//        }
//    }


    //  注册功能
    public boolean register(Scanner scanner) {
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();
        boolean success = userService.register(username, password); // 调用服务层来注册用户
        if (success) {
            System.out.println("注册成功。");
        } else {
            System.out.println("注册失败，用户名已存在。");
        }
        return success;
    }

    //  充值功能
    public boolean rechargeAccount(Scanner scanner) {
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入充值金额:");
        BigDecimal amount = scanner.nextBigDecimal();
        boolean success = userService.recharge(username, amount); // 调用服务层来充值
        if (success) {
            System.out.println("充值成功。");
        } else {
            System.out.println("充值失败。");
        }
        return success;
    }

    //  导航到相应用户界面
    public void navigateToUserInterface(int permissionID) {
        switch (permissionID) {
            case 1:
                new AdminView().displayMenu();
                break;
            case 2:
                new SellerView().displayMenu();
                break;
            case 3:
                new BuyerView().displayMenu();
                break;
            default:
                System.out.println("未知的用户类型。返回主界面。");
        }
    }
}
