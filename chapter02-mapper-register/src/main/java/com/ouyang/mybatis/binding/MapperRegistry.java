package com.ouyang.mybatis.binding;

import cn.hutool.core.util.ClassUtil;
import com.ouyang.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MapperRegistry
 * @Description 映射器注册机
 * @Author OuYang
 * @Date 2023/6/15 13:42
 * @Version 1.0
 */
public class MapperRegistry {

    private Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();


    public void addMappers(String packageName) {
        //扫描该包下的类
        Set<Class<?>> scanPackage = ClassUtil.scanPackage(packageName);
        for (Class<?> mapperClass : scanPackage) {
            addMapperClass(mapperClass);
        }
    }

    public void addMapperClass(Class<?> mapperClass) {
        //判断是否为接口
        if (mapperClass.isInterface()) {
            //判断是否已有该mapper
            if (hasMapper(mapperClass)) {
                // 如果重复添加了，报错
                throw new RuntimeException("Type " + mapperClass + " is already known to the MapperRegistry.");
            }
            knownMappers.put(mapperClass, new MapperProxyFactory<>(mapperClass));
        }
    }

    private boolean hasMapper(Class<?> mapperClass) {
        return knownMappers.containsKey(mapperClass);
    }


    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
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
