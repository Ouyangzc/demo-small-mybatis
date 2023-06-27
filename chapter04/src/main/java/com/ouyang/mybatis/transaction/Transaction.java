package com.ouyang.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName Transaction
 * @Description 事务接口
 * @Author OuYang
 * @Date 2023/6/25 16:00
 * @Version 1.0
 */
public interface Transaction {
    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
