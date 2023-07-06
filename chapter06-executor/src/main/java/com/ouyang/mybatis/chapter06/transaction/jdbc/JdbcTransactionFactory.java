package com.ouyang.mybatis.chapter06.transaction.jdbc;

import com.ouyang.mybatis.chapter06.session.TransactionIsolationLevel;
import com.ouyang.mybatis.chapter06.transaction.Transaction;
import com.ouyang.mybatis.chapter06.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @ClassName JdbcTransactionFactory
 * @Description JDBC事务工厂
 * @Author OuYang
 * @Date 2023/7/5 14:00
 * @Version 1.0
 */
public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection connection) {
        return new JdbcTransaction(connection);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource,level,autoCommit);
    }
}
