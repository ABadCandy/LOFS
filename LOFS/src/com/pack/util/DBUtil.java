package com.pack.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 采用JDBC技术连接MySQL数据库
 * 
 * @author tanghao
 * @date:日期:2016-3-26时间:下午2:31:37
 * @version 1.0
 */
public class DBUtil {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8088/test?useUnicode=true&characterEncoding=utf-8",
                    "root",
                    "1990318");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * @param conn
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
