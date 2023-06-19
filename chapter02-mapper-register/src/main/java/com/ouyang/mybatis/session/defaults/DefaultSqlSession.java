package com.ouyang.mybatis.session.defaults;

import com.ouyang.mybatis.binding.MapperRegistry;
import com.ouyang.mybatis.session.SqlSession;

/**
 * @ClassName DefaultSqlSession
 * @Description TODO
 * @Author OuYang
 * @Date 2023/6/15 13:57
 * @Version 1.0
 */
public class DefaultSqlSession implements SqlSession {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }


    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type,this);
    }
}
