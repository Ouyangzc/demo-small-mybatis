package com.ouyang.mybatis.test;

import com.ouyang.mybatis.binding.MapperProxyFactory;
import com.ouyang.mybatis.binding.MapperRegistry;
import com.ouyang.mybatis.session.SqlSession;
import com.ouyang.mybatis.session.SqlSessionFactory;
import com.ouyang.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.ouyang.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ApiTest
 * @Description 测试类
 * @Author OuYang
 * @Date 2023/6/15 13:33
 * @Version 1.0
 */
public class ApiTest {

    private static Logger logger = LoggerFactory.getLogger(ApiTest.class);


    @Test
    public void test_MapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.ouyang.mybatis.test.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        logger.info("测试结果：{}", res);
    }

}
