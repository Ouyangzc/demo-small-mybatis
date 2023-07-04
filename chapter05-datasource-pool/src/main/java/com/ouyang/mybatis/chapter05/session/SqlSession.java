package com.ouyang.mybatis.chapter05.session;

/**
 * @ClassName SqlSession
 * @Description TODO
 * @Author OuYang
 * @Date 2023/6/28 14:09
 * @Version 1.0
 */
public interface SqlSession {
    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    Configuration getConfiguration();

    <T> T getMapper(Class<T> type);
}
