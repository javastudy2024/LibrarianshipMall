package com.ts.book.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtility {
    private static final ComboPooledDataSource dataSource = new ComboPooledDataSource("mysqlapp");

    // 静态初始化块或者构造器中配置 dataSource 的属性

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close() { // 添加关闭连接池的方法，如果需要的话
        dataSource.close();
    }
}