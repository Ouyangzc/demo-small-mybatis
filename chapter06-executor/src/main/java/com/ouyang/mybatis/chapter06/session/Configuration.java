package com.ouyang.mybatis.chapter06.session;

import com.ouyang.mybatis.chapter06.binding.MapperRegistry;
import com.ouyang.mybatis.chapter06.datasource.druid.DruidDataSourceFactory;
import com.ouyang.mybatis.chapter06.executor.Executor;
import com.ouyang.mybatis.chapter06.executor.SimpleExecutor;
import com.ouyang.mybatis.chapter06.executor.resultset.DefaultResultSetHandler;
import com.ouyang.mybatis.chapter06.executor.resultset.ResultSetHandler;
import com.ouyang.mybatis.chapter06.executor.statement.PreparedStatementHandler;
import com.ouyang.mybatis.chapter06.executor.statement.StatementHandler;
import com.ouyang.mybatis.chapter06.mapping.BoundSql;
import com.ouyang.mybatis.chapter06.mapping.Environment;
import com.ouyang.mybatis.chapter06.mapping.MappedStatement;
import com.ouyang.mybatis.chapter06.transaction.Transaction;
import com.ouyang.mybatis.chapter06.transaction.jdbc.JdbcTransactionFactory;
import com.ouyang.mybatis.chapter06.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Configuration
 * @Description 配置项
 * @Author OuYang
 * @Date 2023/7/5 11:43
 * @Version 1.0
 */
public class Configuration {

    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    private Environment environment;


    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    protected Map<String, MappedStatement> mappedStatements = new HashMap<>();
    public void addMappedStatement(MappedStatement mappedStatement) {
        mappedStatements.put(mappedStatement.getId(), mappedStatement);
    }

    public MappedStatement getMappedStatement(String statement) {
        return mappedStatements.get(statement);
    }

    protected MapperRegistry mapperRegistry = new MapperRegistry(this);
    public <T> void addMapper(Class<T> clazz) {
        mapperRegistry.addMapper(clazz);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type,sqlSession);
    }

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
    }

    public StatementHandler newStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        return new PreparedStatementHandler(executor, mappedStatement, parameter, resultHandler, boundSql);
    }

    public ResultSetHandler newResultSetHandler(Executor executor, MappedStatement mappedStatement, BoundSql boundSql) {
        return new DefaultResultSetHandler(executor, mappedStatement, boundSql);
    }

    public Executor newExecutor(Transaction tx) {
        return new SimpleExecutor(this,tx);
    }
}
