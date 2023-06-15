package com.ouyang.mybatis.test;

import com.ouyang.mybatis.binding.MapperProxyFactory;
import com.ouyang.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ApiTest
 * @Description 测试
 * @Author OuYang
 * @Date 2023/6/15 9:27
 * @Version 1.0
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_proxy_class() {
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, ((proxy, method, args) -> "你得queryUserName方法被代理了"));
        String result = userDao.queryUserName("10001");
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_MapperProxyFactory() {
        MapperProxyFactory<IUserDao> mapperProxyFactory = new MapperProxyFactory<>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("com.ouyang.mybatis.test.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("com.ouyang.mybatis.test.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        IUserDao userDao = mapperProxyFactory.newInstance(sqlSession);
        String res = userDao.queryUserName("10001");
        logger.info("测试queryUserName结果：{}", res);

        Integer age = userDao.queryUserAge("10001");
        logger.info("测试queryUserAge结果：{}", age);

    }
}
