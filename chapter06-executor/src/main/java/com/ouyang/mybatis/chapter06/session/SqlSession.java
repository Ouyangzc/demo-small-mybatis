package com.ouyang.mybatis.chapter06.session;

/**
 * @ClassName SqlSession
 * @Description TODO
 * @Author OuYang
 * @Date 2023/7/5 14:55
 * @Version 1.0
 */
public interface SqlSession {
    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    Configuration getConfiguration();

    <T> T getMapper(Class<T> type);
}
