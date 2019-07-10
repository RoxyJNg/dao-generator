package com.null01.dbmetadata;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * Created by Roxy on 2019/7/10.
 */
@Component
public class DbConnection {
    @Autowired
    private DbProperties properties;

    private static final Logger logger = LoggerFactory.getLogger(DbConnection.class);

    public Connection getConn(){
        DruidDataSource dataSource;
        try{
            dataSource  =new DruidDataSource();
            dataSource.setDriverClassName(properties.getDriverClassName());
            dataSource.setUrl(properties.getUrl());
            dataSource.setUsername(properties.getUsername());
            dataSource.setPassword(properties.getPassword());
            dataSource.setInitialSize(properties.getInitialSize());
            dataSource.setMinIdle(properties.getMinIdle());
            dataSource.setMaxActive(properties.getMaxActive());
            dataSource.setMaxWait(properties.getMaxWait());
            dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
            dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
            dataSource.setValidationQuery(properties.getValidationQuery());
            dataSource.setTestWhileIdle(properties.isTestWhileIdle());
            dataSource.setTestOnBorrow(properties.isTestOnBorrow());
            dataSource.setTestOnReturn(properties.isTestOnReturn());
            return dataSource.getConnection();
        }catch (Exception ex){
            logger.error(ex.getMessage());
            return null;
        }
    }
}
