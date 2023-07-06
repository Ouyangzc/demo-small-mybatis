package com.ouyang.mybatis.chapter06.test.dao;

import com.ouyang.mybatis.chapter06.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}
