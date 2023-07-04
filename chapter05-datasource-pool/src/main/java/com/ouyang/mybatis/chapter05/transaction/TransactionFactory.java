package com.ouyang.mybatis.chapter05.transaction;

import com.ouyang.mybatis.chapter05.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @ClassName TransactionFactory
 * @Description 事务工厂
 * @Author OuYang
 * @Date 2023/6/28 10:44
 * @Version 1.0
 */
public interface TransactionFactory {

    Transaction newTransaction(Connection connection);

    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);

}
