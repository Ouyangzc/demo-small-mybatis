package com.ouyang.mybatis.chapter06.transaction.jdbc;

import com.ouyang.mybatis.chapter06.session.TransactionIsolationLevel;
import com.ouyang.mybatis.chapter06.transaction.Transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName JdbcTransaction
 * @Description jdbc事务
 * @Author OuYang
 * @Date 2023/7/5 13:44
 * @Version 1.0
 */
public class JdbcTransaction implements Transaction {

    protected Connection connection;

    protected DataSource dataSource;

    protected TransactionIsolationLevel level = TransactionIsolationLevel.NONE;

    protected boolean autoCommit;

    public JdbcTransaction(Connection connection) {
        this.connection = connection;
    }

    public JdbcTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        this.dataSource = dataSource;
        this.level = level;
        this.autoCommit = autoCommit;
    }

    @Override
    public Connection getConnnection() throws SQLException {
        connection = dataSource.getConnection();
        connection.setAutoCommit(autoCommit);
        connection.setTransactionIsolation(level.getLevel());
        return connection;
    }

    @Override
    public void commit() throws SQLException {
        if (null!=connection && !connection.getAutoCommit()){
            connection.commit();
        }

    }

    @Override
    public void rollback() throws SQLException {
        if (null!=connection && !connection.getAutoCommit()){
            connection.rollback();
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null && !connection.getAutoCommit()) {
            connection.close();
        }
    }
}
