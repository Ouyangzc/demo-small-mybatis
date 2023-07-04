package com.ouyang.mybatis.chapter05.session;

/**
 * @ClassName SqlSessionFactory
 * @Description sql session工厂
 * @Author OuYang
 * @Date 2023/6/28 15:07
 * @Version 1.0
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
