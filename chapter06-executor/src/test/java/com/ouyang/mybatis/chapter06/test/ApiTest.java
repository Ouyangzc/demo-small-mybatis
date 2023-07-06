package com.ouyang.mybatis.chapter06.test;

import cn.hutool.json.JSONUtil;
import com.ouyang.mybatis.chapter06.io.Resources;
import com.ouyang.mybatis.chapter06.session.SqlSession;
import com.ouyang.mybatis.chapter06.session.SqlSessionFactory;
import com.ouyang.mybatis.chapter06.session.SqlSessionFactoryBuilder;
import com.ouyang.mybatis.chapter06.test.dao.IUserDao;
import com.ouyang.mybatis.chapter06.test.po.User;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @ClassName ApiTest
 * @Description 测试磊
 * @Author OuYang
 * @Date 2023/7/5 11:08
 * @Version 1.0
 */
public class ApiTest {


    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_datasource() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", JSONUtil.toJsonStr(user));
    }
}
