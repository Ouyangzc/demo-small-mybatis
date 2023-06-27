package com.ouyang.mybatis.session;

/**
 * @ClassName SqlSessionFactory
 * @Description sql session工厂
 * @Author OuYang
 * @Date 2023/6/21 13:44
 * @Version 1.0
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
