package com.ouyang.mybatis.test.dao;

import com.ouyang.mybatis.test.po.Activity;

public interface IActivityDao {

    Activity queryActivityById(Activity activity);

    Integer insert(Activity activity);

}
