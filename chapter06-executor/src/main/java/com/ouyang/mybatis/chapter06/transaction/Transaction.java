package com.ouyang.mybatis.chapter06.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName Transaction
 * @Description 事务接口
 * @Author OuYang
 * @Date 2023/7/5 13:42
 * @Version 1.0
 */
public interface Transaction {
    Connection getConnnection()throws SQLException;

    void commit()throws SQLException;

    void rollback()throws SQLException;


    void close()throws SQLException;
}
