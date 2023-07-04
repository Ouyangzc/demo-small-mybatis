package com.ouyang.mybatis.chapter05.test.dao;

import com.ouyang.mybatis.chapter05.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}
