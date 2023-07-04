package com.ouyang.mybatis.chapter05.binding;

import com.ouyang.mybatis.chapter05.session.Configuration;
import com.ouyang.mybatis.chapter05.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapperRegistry
 * @Description TODO
 * @Author OuYang
 * @Date 2023/6/28 11:38
 * @Version 1.0
 */
public class MapperRegistry {

    private Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    private Configuration configuration;

    public MapperRegistry(Configuration configuration) {
        this.configuration = configuration;
    }


    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (null == mapperProxyFactory) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public <T> void addMapper(Class<T> type) {
        if (type.isInterface()) {
            if (hasMapper(type)) {
                // 如果重复添加了，报错
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }

    }

    private <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }
}
