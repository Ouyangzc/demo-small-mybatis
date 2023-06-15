package com.ouyang.mybatis.binding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.Map;

/**
 * @ClassName MapperProxy
 * @Description 映射代理类
 * @Author OuYang
 * @Date 2023/6/15 9:21
 * @Version 1.0
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {
    private Logger logger = LoggerFactory.getLogger(MapperProxy.class);
    private Map<String, String> sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            //获取方法返回值类型
            Type type = method.getGenericReturnType();

            if (type instanceof ParameterizedType) {
                //参数化泛型信息--List<String>
                logger.info("type:{}", type);
                // 强制转型为带参数的泛型类型
                Type[] typesto = ((ParameterizedType) type).getActualTypeArguments();
            } else if (type instanceof GenericArrayType) {
                //泛型数组类型--ClassA<T>[][]
                logger.info("数组类型:{}", type);
            } else if (type instanceof Class) {
                //基本类型
                String name = ((Class) type).getName();
                if ("java.lang.String".equals(name)) {
                    return "你的被代理了！" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
                } else if ("java.lang.Integer".equals(name)) {
                    return 1;
                }
            } else if (type instanceof WildcardType) {
                //通配泛型信息--List<? extend Object>
                String typeName = type.getTypeName();
            }
            return "1";
        }
    }
}
