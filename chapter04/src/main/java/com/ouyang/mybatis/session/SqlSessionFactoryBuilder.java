package com.ouyang.mybatis.session;

import com.ouyang.mybatis.builder.xml.XMLConfigBuilder;
import com.ouyang.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @ClassName SqlSessionFactoryBuilder
 * @Description 构建SqlSessionFactory的工厂
 * @Author OuYang
 * @Date 2023/6/21 11:10
 * @Version 1.0
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    private SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
