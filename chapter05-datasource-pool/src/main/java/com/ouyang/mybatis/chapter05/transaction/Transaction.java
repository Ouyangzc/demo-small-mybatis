package com.ouyang.mybatis.chapter05.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName Transaction
 * @Description 事务
 * @Author OuYang
 * @Date 2023/6/28 10:44
 * @Version 1.0
 */
public interface Transaction {
    Connection getConnnection()throws SQLException;

    void commit()throws SQLException;

    void rollback()throws SQLException;


    void close()throws SQLException;
}
