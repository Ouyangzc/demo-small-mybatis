package com.ouyang.mybatis.chapter06.binding;

import com.ouyang.mybatis.chapter06.session.SqlSession;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName MapperProxyFactory
 * @Description 映射器代理工厂
 * @Author OuYang
 * @Date 2023/7/5 14:35
 * @Version 1.0
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    private Map<Method, MapperMethod> methodCache = new ConcurrentHashMap<Method, MapperMethod>();

    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface,methodCache);
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{mapperInterface}, mapperProxy);
    }


}
