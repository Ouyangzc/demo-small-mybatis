package com.ouyang.mybatis.chapter06.executor;

import com.ouyang.mybatis.chapter06.mapping.BoundSql;
import com.ouyang.mybatis.chapter06.mapping.MappedStatement;
import com.ouyang.mybatis.chapter06.session.ResultHandler;
import com.ouyang.mybatis.chapter06.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName Executor
 * @Description 执行器
 * 事务相关的处理方法和执行SQL查询的操作
 * @Author OuYang
 * @Date 2023/7/6 9:00
 * @Version 1.0
 */
public interface Executor {
    ResultHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);


    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);


}
