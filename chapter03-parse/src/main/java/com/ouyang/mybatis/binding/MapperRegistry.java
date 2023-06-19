package com.ouyang.mybatis.binding;

import cn.hutool.core.util.ClassUtil;
import com.ouyang.mybatis.session.Configuration;
import com.ouyang.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MapperRegistry
 * @Description mapper注册器
 * @Author OuYang
 * @Date 2023/6/19 11:46
 * @Version 1.0
 */
public class MapperRegistry {

    private Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    private Configuration configuration;

    public MapperRegistry(Configuration configuration) {
        this.configuration = configuration;
    }


    public void addMappers(String packageName) {
        Set<Class<?>> packageClasses = ClassUtil.scanPackage(packageName);
        for (Class classes : packageClasses) {
            addMapper(classes);
        }
    }

    public <T> void addMapper(Class<T> type ) {
        if (type.isInterface()) {
            if (hasMapper(type)) {
                // 如果重复添加了，报错
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }

    }

    public boolean hasMapper(Class mapperClass) {
        return knownMappers.containsKey(mapperClass);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }
}
