package com.ouyang.mybatis.transaction.jdbc;

import com.ouyang.mybatis.session.TransactionIsolationLevel;
import com.ouyang.mybatis.transaction.Transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName JdbcTransaction
 * @Description jdbc事务
 * @Author OuYang
 * @Date 2023/6/26 10:22
 * @Version 1.0
 */
public class JdbcTransaction implements Transaction {
    protected Connection connection;
    protected DataSource dataSource;

    protected TransactionIsolationLevel level = TransactionIsolationLevel.NONE;

    protected boolean autoCommit;

    public JdbcTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        this.dataSource = dataSource;
        this.level = level;
        this.autoCommit = autoCommit;
    }

    public JdbcTransaction(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        connection.setTransactionIsolation(level.getLevel());
        connection.setAutoCommit(autoCommit);
        return connection;
    }

    @Override
    public void commit() throws SQLException {
        if (connection != null && !connection.getAutoCommit()) {
            connection.commit();
        }
    }

    @Override
    public void rollback() throws SQLException {
        if (connection != null && !connection.getAutoCommit()) {
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
