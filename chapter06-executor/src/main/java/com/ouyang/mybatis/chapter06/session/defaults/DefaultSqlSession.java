package com.ouyang.mybatis.chapter06.session.defaults;

import com.ouyang.mybatis.chapter06.executor.Executor;
import com.ouyang.mybatis.chapter06.mapping.MappedStatement;
import com.ouyang.mybatis.chapter06.session.Configuration;
import com.ouyang.mybatis.chapter06.session.SqlSession;

import java.util.List;

/**
 * @ClassName DefaultSqlSession
 * @Description 默认sqlsession实现类
 * @Author OuYang
 * @Date 2023/7/5 16:26
 * @Version 1.0
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Executor executor;


    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement(statement);
        List<T> list = executor.query(ms, parameter, Executor.NO_RESULT_HANDLER, ms.getBoundSql());
        return list.get(0);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

}
