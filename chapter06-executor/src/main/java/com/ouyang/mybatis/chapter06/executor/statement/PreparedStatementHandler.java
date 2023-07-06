package com.ouyang.mybatis.chapter06.executor.statement;

import com.ouyang.mybatis.chapter06.executor.Executor;
import com.ouyang.mybatis.chapter06.mapping.BoundSql;
import com.ouyang.mybatis.chapter06.mapping.MappedStatement;
import com.ouyang.mybatis.chapter06.session.ResultHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @ClassName PreparedStatementHandler
 * @Description 预处理语句处理器
 * @Author OuYang
 * @Date 2023/7/6 13:24
 * @Version 1.0
 */
public class PreparedStatementHandler extends BaseStatementHandler{


    public PreparedStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, ResultHandler resultHandler,BoundSql boundSql) {
        super(executor, mappedStatement, parameterObject, resultHandler,boundSql);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        String sql = boundSql.getSql();
        return connection.prepareStatement(sql);
    }

    @Override
    public void parameterize(Statement statement) throws SQLException {
        PreparedStatement ps = (PreparedStatement) statement;
        ps.setLong(1, Long.parseLong(((Object[]) parameterObject)[0].toString()));
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        PreparedStatement ps = (PreparedStatement) statement;
        ps.execute();
        return resultSetHandler.<E> handleResultSets(ps);
    }
}
