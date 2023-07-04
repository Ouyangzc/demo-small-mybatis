package com.ouyang.mybatis.chapter05.test;

import cn.hutool.json.JSONUtil;
import com.ouyang.mybatis.chapter05.builder.xml.XmlConfigBuilder;
import com.ouyang.mybatis.chapter05.io.Resources;
import com.ouyang.mybatis.chapter05.session.Configuration;
import com.ouyang.mybatis.chapter05.session.SqlSession;
import com.ouyang.mybatis.chapter05.session.SqlSessionFactory;
import com.ouyang.mybatis.chapter05.session.SqlSessionFactoryBuilder;
import com.ouyang.mybatis.chapter05.session.defaults.DefaultSqlSession;
import com.ouyang.mybatis.chapter05.test.dao.IUserDao;
import com.ouyang.mybatis.chapter05.test.po.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @ClassName ApiTest
 * @Description 测试工具类
 * @Author OuYang
 * @Date 2023/6/27 13:56
 * @Version 1.0
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 解析 XML
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder(reader);
        Configuration configuration = xmlConfigBuilder.parse();

        // 获取 DefaultSqlSession
        SqlSession sqlSession = new DefaultSqlSession(configuration);


        // 执行查询：默认是一个集合参数
        Object[] req = {1L};
        Object res = sqlSession.selectOne("com.ouyang.mybatis.chapter05.test.dao.IUserDao.queryUserInfoById", req);
        logger.info("测试结果：{}", JSONUtil.toJsonStr(res));

    }

    @Test
    public void test_datasource() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);


        // 3. 测试验证
        for (int i = 0; i < 50; i++) {
            User user = userDao.queryUserInfoById(1L);
            logger.info("测试结果：{}",JSONUtil.toJsonStr(user));
        }
    }



}
