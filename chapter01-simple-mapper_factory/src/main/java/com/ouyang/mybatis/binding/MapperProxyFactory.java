package com.ouyang.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @ClassName MapperProxyFactory
 * @Description 映射器代理工厂
 * @Author OuYang
 * @Date 2023/6/15 9:25
 * @Version 1.0
 */
public class MapperProxyFactory <T>{
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String, String> sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
