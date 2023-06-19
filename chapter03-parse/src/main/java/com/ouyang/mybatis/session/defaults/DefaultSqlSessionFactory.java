package com.ouyang.mybatis.session.defaults;

import com.ouyang.mybatis.binding.MapperRegistry;
import com.ouyang.mybatis.session.Configuration;
import com.ouyang.mybatis.session.SqlSession;
import com.ouyang.mybatis.session.SqlSessionFactory;

/**
 * @ClassName DefaultSqlSessionFactory
 * @Description TODO
 * @Author OuYang
 * @Date 2023/6/19 13:45
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
