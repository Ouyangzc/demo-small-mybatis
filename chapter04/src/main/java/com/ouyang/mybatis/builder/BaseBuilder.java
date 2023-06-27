package com.ouyang.mybatis.builder;

import com.ouyang.mybatis.session.Configuration;
import com.ouyang.mybatis.type.TypeAliasRegistry;

/**
 * @ClassName BaseBuilder
 * @Description 构建器的基类，建造者模式
 * @Author OuYang
 * @Date 2023/6/21 11:11
 * @Version 1.0
 */
public class BaseBuilder {
    protected final Configuration configuration;

    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
