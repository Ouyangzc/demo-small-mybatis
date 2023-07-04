package com.ouyang.mybatis.chapter05.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.ouyang.mybatis.chapter05.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @ClassName DruidDataSourceFactory
 * @Description druid数据库连接池
 * @Author OuYang
 * @Date 2023/6/28 10:52
 * @Version 1.0
 */
public class DruidDataSourceFactory implements DataSourceFactory {
    private Properties props;
    @Override
    public void setProperties(Properties props) {
        this.props = props;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(props.getProperty("driver"));
        dataSource.setUrl(props.getProperty("url"));
        dataSource.setUsername(props.getProperty("username"));
        dataSource.setPassword(props.getProperty("password"));
        return dataSource;
    }
}
