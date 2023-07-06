package com.ouyang.mybatis.chapter06.executor.statement;

import com.ouyang.mybatis.chapter06.executor.Executor;
import com.ouyang.mybatis.chapter06.executor.resultset.ResultSetHandler;
import com.ouyang.mybatis.chapter06.mapping.BoundSql;
import com.ouyang.mybatis.chapter06.mapping.MappedStatement;
import com.ouyang.mybatis.chapter06.session.Configuration;
import com.ouyang.mybatis.chapter06.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName BaseStatementHandler
 * @Description 语句处理器抽象基类
 * @Author OuYang
 * @Date 2023/7/6 11:08
 * @Version 1.0
 */
public abstract class BaseStatementHandler implements StatementHandler {

    protected final Configuration configuration;

    protected final Executor executor;

    protected final MappedStatement mappedStatement;

    protected final Object parameterObject;
    protected final ResultSetHandler resultSetHandler;
    protected final BoundSql boundSql;

    public BaseStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject,ResultHandler resultHandler, BoundSql boundSql) {
        this.configuration = mappedStatement.getConfiguration();
        this.executor = executor;
        this.mappedStatement = mappedStatement;
        this.boundSql = boundSql;
        this.parameterObject = parameterObject;
        this.resultSetHandler = configuration.newResultSetHandler(executor, mappedStatement, boundSql);
    }

    @Override
    public Statement prepare(Connection connection) throws SQLException {
        Statement statement = null;
        try {
            // 实例化 Statement
            statement = instantiateStatement(connection);
            // 参数设置，可以被抽取，提供配置
            statement.setQueryTimeout(350);
            statement.setFetchSize(10000);
            return statement;
        } catch (Exception e) {
            throw new RuntimeException("Error preparing statement.  Cause: " + e, e);
        }
    }

    protected abstract Statement instantiateStatement(Connection connection)throws SQLException;
}
