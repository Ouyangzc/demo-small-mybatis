package com.ouyang.mybatis.chapter05.session;


import com.ouyang.mybatis.chapter05.builder.xml.XmlConfigBuilder;
import com.ouyang.mybatis.chapter05.session.defaults.DefaultSqlSessionFactory;


import java.io.Reader;

/**
 * @ClassName SqlSessionFactoryBuilder
 * @Description 构建SqlSessionFactory的工厂
 * @Author OuYang
 * @Date 2023/7/4 9:12
 * @Version 1.0
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader){
        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
