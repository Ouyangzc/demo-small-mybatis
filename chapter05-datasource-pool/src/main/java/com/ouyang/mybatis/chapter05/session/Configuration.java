package com.ouyang.mybatis.chapter05.session;

import com.ouyang.mybatis.chapter05.binding.MapperRegistry;
import com.ouyang.mybatis.chapter05.datasource.druid.DruidDataSourceFactory;
import com.ouyang.mybatis.chapter05.datasource.pooled.PooledDataSourceFactory;
import com.ouyang.mybatis.chapter05.datasource.unpooled.UnpooledDataSourceFactory;
import com.ouyang.mybatis.chapter05.mapping.Environment;
import com.ouyang.mybatis.chapter05.mapping.MappedStatement;
import com.ouyang.mybatis.chapter05.transaction.jdbc.JdbcTransactionFactory;
import com.ouyang.mybatis.chapter05.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Configuration
 * @Description 配置项
 * @Author OuYang
 * @Date 2023/6/27 14:43
 * @Version 1.0
 */
public class Configuration {

    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    private Environment environment;

    protected Map<String, MappedStatement> mappedStatements = new HashMap<>();

    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
        typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class);
        typeAliasRegistry.registerAlias("POOLED", PooledDataSourceFactory.class);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void addMappedStatement(MappedStatement mappedStatement) {
        mappedStatements.put(mappedStatement.getId(), mappedStatement);
    }

    public MappedStatement getMappedStatement(String statement) {
        return mappedStatements.get(statement);
    }

    public <T> void addMapper(Class<T> clazz) {
        mapperRegistry.addMapper(clazz);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return (T) mapperRegistry.getMapper(type, sqlSession);
    }
}
