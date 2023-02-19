package com.mingshashan.mybatis.learn.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {

    public static void main(String[] args) {
        try {
            String driverClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverClass);

            String url = "jdbc:mysql://192.168.254.201:3306/order?useSSL=false";
            String user = "root";
            String password = "000000";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            String sql = "SELECT NAME FROM T_ARG_PRODUCT WHERE ID = '809195658207559680'";
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
