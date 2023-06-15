package com.ouyang.mybatis.test.dao;

/**
 * @ClassName IUserDao
 * @Description dao 映射文件
 * @Author OuYang
 * @Date 2023/6/15 9:27
 * @Version 1.0
 */
public interface IUserDao {
    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
