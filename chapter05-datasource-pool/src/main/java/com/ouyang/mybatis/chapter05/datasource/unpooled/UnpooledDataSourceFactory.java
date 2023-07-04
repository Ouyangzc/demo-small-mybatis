package com.ouyang.mybatis.chapter05.datasource.unpooled;

import com.ouyang.mybatis.chapter05.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @ClassName UnpooledDataSourceFactory
 * @Description 无池化数据源工厂
 * @Author OuYang
 * @Date 2023/7/3 14:45
 * @Version 1.0
 */
public class UnpooledDataSourceFactory implements DataSourceFactory {

    protected Properties props;

    @Override
    public void setProperties(Properties props) {
        this.props = props;
    }

    @Override
    public DataSource getDataSource() {
        UnpooledDataSource unpooledDataSource = new UnpooledDataSource();
        unpooledDataSource.setDriver(props.getProperty("driver"));
        unpooledDataSource.setUrl(props.getProperty("url"));
        unpooledDataSource.setUsername(props.getProperty("username"));
        unpooledDataSource.setPassword(props.getProperty("password"));
        return unpooledDataSource;
    }
}
