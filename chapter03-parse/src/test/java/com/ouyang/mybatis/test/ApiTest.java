package com.ouyang.mybatis.test;

import com.ouyang.mybatis.io.Resources;
import com.ouyang.mybatis.session.SqlSession;
import com.ouyang.mybatis.session.SqlSessionFactory;
import com.ouyang.mybatis.session.SqlSessionFactoryBuilder;
import com.ouyang.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @ClassName ApiTest
 * @Description TODO
 * @Author OuYang
 * @Date 2023/6/19 10:08
 * @Version 1.0
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}", res);

    }
}
