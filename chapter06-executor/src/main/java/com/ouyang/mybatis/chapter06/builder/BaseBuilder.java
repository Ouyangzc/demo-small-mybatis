package com.ouyang.mybatis.chapter06.builder;

import com.ouyang.mybatis.chapter06.session.Configuration;
import com.ouyang.mybatis.chapter06.type.TypeAliasRegistry;

/**
 * @ClassName BaseBuilder
 * @Description 构建器的基类，建造者模式
 * @Author OuYang
 * @Date 2023/7/5 11:42
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
