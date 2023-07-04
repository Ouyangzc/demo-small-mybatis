package com.ouyang.mybatis.chapter05.session.defaults;

import com.ouyang.mybatis.chapter05.session.Configuration;
import com.ouyang.mybatis.chapter05.session.SqlSession;
import com.ouyang.mybatis.chapter05.session.SqlSessionFactory;

/**
 * @ClassName DefaultSqlSessionFactory
 * @Description 默认的 DefaultSqlSessionFactory
 * @Author OuYang
 * @Date 2023/7/4 9:20
 * @Version 1.0
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
