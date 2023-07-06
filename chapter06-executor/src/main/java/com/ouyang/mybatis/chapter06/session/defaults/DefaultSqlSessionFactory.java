package com.ouyang.mybatis.chapter06.session.defaults;

import com.ouyang.mybatis.chapter06.executor.Executor;
import com.ouyang.mybatis.chapter06.mapping.Environment;
import com.ouyang.mybatis.chapter06.session.Configuration;
import com.ouyang.mybatis.chapter06.session.SqlSession;
import com.ouyang.mybatis.chapter06.session.SqlSessionFactory;
import com.ouyang.mybatis.chapter06.session.TransactionIsolationLevel;
import com.ouyang.mybatis.chapter06.transaction.Transaction;
import com.ouyang.mybatis.chapter06.transaction.TransactionFactory;

/**
 * @ClassName DefaultSqlSessionFactory
 * @Description TODO
 * @Author OuYang
 * @Date 2023/7/5 16:45
 * @Version 1.0
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        final  Environment environment = configuration.getEnvironment();
        TransactionFactory transactionFactory = environment.getTransactionFactory();
        Transaction tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
        final Executor executor = configuration.newExecutor(tx);
        // 创建DefaultSqlSession
        return new DefaultSqlSession(configuration, executor);
    }
}
