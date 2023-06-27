package com.ouyang.mybatis.session;

import com.ouyang.mybatis.binding.MapperRegistry;
import com.ouyang.mybatis.datasource.druid.DruidDataSourceFactory;
import com.ouyang.mybatis.mapping.Environment;
import com.ouyang.mybatis.mapping.MappedStatement;
import com.ouyang.mybatis.transaction.jdbc.JdbcTransactionFactory;
import com.ouyang.mybatis.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Configuration
 * @Description TODO
 * @Author OuYang
 * @Date 2023/6/21 11:11
 * @Version 1.0
 */
public class Configuration {
    protected Map<String,MappedStatement> mappedStatements = new HashMap<>();

    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    protected Environment environment;
    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String statement) {
        return mappedStatements.get(statement);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public  <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }
}
