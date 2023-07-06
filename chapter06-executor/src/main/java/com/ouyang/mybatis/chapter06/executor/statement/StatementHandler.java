package com.ouyang.mybatis.chapter06.executor.statement;

import com.ouyang.mybatis.chapter06.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @ClassName StatementHandler
 * @Description 语句处理器
 * @Author OuYang
 * @Date 2023/7/6 9:24
 * @Version 1.0
 */
public interface StatementHandler {

    Statement prepare(Connection connection) throws SQLException;

    void parameterize(Statement statement) throws SQLException;

    <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException;
}
