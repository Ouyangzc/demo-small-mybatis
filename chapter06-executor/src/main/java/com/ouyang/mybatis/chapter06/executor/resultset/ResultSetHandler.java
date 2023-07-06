package com.ouyang.mybatis.chapter06.executor.resultset;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @ClassName ResultSetHandler
 * @Description 结果集处理器
 * @Author OuYang
 * @Date 2023/7/6 13:17
 * @Version 1.0
 */
public interface ResultSetHandler {
    <E> List<E> handleResultSets(Statement stmt) throws SQLException;
}
