package com.ouyang.mybatis.builder;

import com.ouyang.mybatis.session.Configuration;

/**
 * @ClassName BaseBuilder
 * @Description 构建器的基类，建造者模式
 * @Author OuYang
 * @Date 2023/6/19 14:43
 * @Version 1.0
 */
public abstract class BaseBuilder {
    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
