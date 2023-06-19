package com.ouyang.mybatis.session.defaults;

import com.ouyang.mybatis.binding.MapperRegistry;
import com.ouyang.mybatis.session.SqlSession;
import com.ouyang.mybatis.session.SqlSessionFactory;

/**
 * @ClassName DefaultSqlSessionFactory
 * @Description sql session 工厂
 * @Author OuYang
 * @Date 2023/6/15 13:55
 * @Version 1.0
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry registry;

    public DefaultSqlSessionFactory(MapperRegistry registry) {
        this.registry = registry;
    }


    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(registry);
    }
}
