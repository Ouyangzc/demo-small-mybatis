package com.ouyang.mybatis.chapter06.session;

import com.ouyang.mybatis.chapter06.builder.xml.XmlConfigBuilder;
import com.ouyang.mybatis.chapter06.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @ClassName SqlSessionFactoryBuilder
 * @Description 构建SqlSessionFactory的工厂
 * @Author OuYang
 * @Date 2023/7/5 16:24
 * @Version 1.0
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
