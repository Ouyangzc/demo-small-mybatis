package com.ouyang.mybatis.chapter06.binding;

import com.ouyang.mybatis.chapter06.session.Configuration;
import com.ouyang.mybatis.chapter06.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapperRegistry
 * @Description TODO
 * @Author OuYang
 * @Date 2023/7/5 14:32
 * @Version 1.0
 */
public class MapperRegistry {
    private Configuration configuration;

    public MapperRegistry(Configuration configuration) {
        this.configuration = configuration;
    }

    private Map<Class<?>, MapperProxyFactory<?>> knowsMapper = new HashMap<>();

    public <T> void addMapper(Class<T> type) {
        if (type.isInterface()) {
            if (hasMapper(type)) {
                // 如果重复添加了，报错
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            knowsMapper.put(type, new MapperProxyFactory<>(type));
        }
    }

    private <T> boolean hasMapper(Class<T> type) {
        return knowsMapper.containsKey(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knowsMapper.get(type);
        if (null == mapperProxyFactory) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }
}
