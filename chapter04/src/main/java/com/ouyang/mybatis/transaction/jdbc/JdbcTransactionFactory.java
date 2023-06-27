package com.ouyang.mybatis.transaction.jdbc;

import com.ouyang.mybatis.session.TransactionIsolationLevel;
import com.ouyang.mybatis.transaction.Transaction;
import com.ouyang.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @ClassName JdbcTransactionFactory
 * @Description jdbc事务工厂
 * @Author OuYang
 * @Date 2023/6/26 10:22
 * @Version 1.0
 */
public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
