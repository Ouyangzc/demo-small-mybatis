package com.ouyang.mybatis.chapter06.executor;

import com.ouyang.mybatis.chapter06.executor.statement.StatementHandler;
import com.ouyang.mybatis.chapter06.mapping.BoundSql;
import com.ouyang.mybatis.chapter06.mapping.MappedStatement;
import com.ouyang.mybatis.chapter06.session.Configuration;
import com.ouyang.mybatis.chapter06.session.ResultHandler;
import com.ouyang.mybatis.chapter06.transaction.Transaction;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 * @ClassName SimpleExecutor
 * @Description 简单执行器
 * @Author OuYang
 * @Date 2023/7/6 9:19
 * @Version 1.0
 */
public class SimpleExecutor extends BaseExecutor{
    public SimpleExecutor(Configuration configuration, Transaction transaction) {
        super(configuration, transaction);
    }

    @Override
    protected <E> List<E> doQuery(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        try{
            Configuration configuration = ms.getConfiguration();
            StatementHandler statementHandler = configuration.newStatementHandler(this,ms,parameter,resultHandler,boundSql);
            Connection connnection = transaction.getConnnection();
            Statement statement = statementHandler.prepare(connnection);
            statementHandler.parameterize(statement);
            return statementHandler.query(statement,resultHandler);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
