package com.ouyang.mybatis.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @ClassName JdbcTest
 * @Description jdbc 测试
 * @Author OuYang
 * @Date 2023/6/14 11:38
 * @Version 1.0
 */
public class JdbcTest {
    @Test
    public void test_jdbc() throws Exception {
        //1、加载数据库驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2.连接信息
        String url = "jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8&serverTimezone=Asia/Shanghai&allowMultiQueries=true";
        String username = "root";
        String password = "123456";

        // 3.创建连接
        Connection connection = DriverManager.getConnection(url, username, password);

        //4、创建语句
        Statement statement = connection.createStatement();

        // 5.待执行SQL
        String sql = "SELECT id, userId, userName, userHead FROM user";

        // 6.执行SQL，并输出结果
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.print("id=" + resultSet.getObject("id") + " ");
            System.out.print("userId=" + resultSet.getObject("userId") + " ");
            System.out.print("userName=" + resultSet.getObject("userName") + " ");
            System.out.print("userHead=" + resultSet.getObject("userHead"));
        }

        // 7.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
