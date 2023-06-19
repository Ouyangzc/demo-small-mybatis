package com.ouyang.mybatis.session;

/**
 * @ClassName SqlSessionFactory
 * @Description 工厂模式接口，构建SqlSession的工厂
 * @Author OuYang
 * @Date 2023/6/19 11:21
 * @Version 1.0
 */
public interface SqlSessionFactory {
    /**
     *
     * @return
     */
    SqlSession openSession();
}
