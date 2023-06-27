package com.ouyang.mybatis.test;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.ouyang.mybatis.builder.xml.XMLConfigBuilder;
import com.ouyang.mybatis.io.Resources;
import com.ouyang.mybatis.session.Configuration;
import com.ouyang.mybatis.session.SqlSession;
import com.ouyang.mybatis.session.defaults.DefaultSqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @ClassName ApiTest
 * @Description TODO
 * @Author OuYang
 * @Date 2023/6/25 13:54
 * @Version 1.0
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 解析 XML
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        Configuration configuration = xmlConfigBuilder.parse();

        // 获取 DefaultSqlSession
        SqlSession sqlSession = new DefaultSqlSession(configuration);


        // 执行查询：默认是一个集合参数
        Object[] req = {1L};
        Object res = sqlSession.selectOne("com.ouyang.mybatis.test.dao.IUserDao04.queryUserInfoById04", req);
        logger.info("测试结果：{}", JSONUtil.toJsonStr(res));

    }
}
