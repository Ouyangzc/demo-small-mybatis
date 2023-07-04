package com.ouyang.mybatis.chapter05.session;

import java.sql.Connection;

/**
 * @ClassName TransactionIsolationLevel
 * @Description 事务得隔离级别
 * @Author OuYang
 * @Date 2023/6/28 10:50
 * @Version 1.0
 */
public enum TransactionIsolationLevel {
    //包括JDBC支持的5个级别
    NONE(Connection.TRANSACTION_NONE),
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

    private final int level;

    TransactionIsolationLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
