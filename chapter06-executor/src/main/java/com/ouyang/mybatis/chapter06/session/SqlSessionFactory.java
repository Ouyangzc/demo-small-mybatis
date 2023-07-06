package com.ouyang.mybatis.chapter06.session;

/**
 * @ClassName SqlSessionFactory
 * @Description sql session工厂
 * @Author OuYang
 * @Date 2023/7/5 16:24
 * @Version 1.0
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
