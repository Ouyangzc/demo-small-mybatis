package com.ouyang.mybatis.chapter05.datasource.pooled;

import com.ouyang.mybatis.chapter05.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

/**
 * @ClassName PooledDataSourceFactory
 * @Description 有连接池的数据源工厂
 * @Author OuYang
 * @Date 2023/7/3 14:45
 * @Version 1.0
 */
public class PooledDataSourceFactory extends UnpooledDataSourceFactory {


    @Override
    public DataSource getDataSource() {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver(props.getProperty("driver"));
        pooledDataSource.setUrl(props.getProperty("url"));
        pooledDataSource.setUsername(props.getProperty("username"));
        pooledDataSource.setPassword(props.getProperty("password"));
        return pooledDataSource;
    }
}
