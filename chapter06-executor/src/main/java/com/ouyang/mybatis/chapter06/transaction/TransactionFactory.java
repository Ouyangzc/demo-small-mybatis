package com.ouyang.mybatis.chapter06.transaction;



import com.ouyang.mybatis.chapter06.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @ClassName TransactionFactory
 * @Description 事务工厂
 * @Author OuYang
 * @Date 2023/7/5 13:43
 * @Version 1.0
 */
public interface TransactionFactory {
    Transaction newTransaction(Connection connection);

    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);
}
