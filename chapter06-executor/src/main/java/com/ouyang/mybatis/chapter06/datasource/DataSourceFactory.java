package com.ouyang.mybatis.chapter06.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @ClassName DataSourceFactory
 * @Description 数据源工厂
 * @Author OuYang
 * @Date 2023/7/5 14:01
 * @Version 1.0
 */
public interface DataSourceFactory {
    void setProperties(Properties props);

    DataSource getDataSource();
}
