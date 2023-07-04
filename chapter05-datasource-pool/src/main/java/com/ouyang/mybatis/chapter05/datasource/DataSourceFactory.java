package com.ouyang.mybatis.chapter05.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @ClassName DataSourceFactory
 * @Description 数据源工厂
 * @Author OuYang
 * @Date 2023/6/28 10:52
 * @Version 1.0
 */
public interface DataSourceFactory {
    void setProperties(Properties props);

    DataSource getDataSource();
}
