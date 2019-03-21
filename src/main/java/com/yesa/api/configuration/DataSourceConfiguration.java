/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yesa.api.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author yalli
 */
@Configuration
public class DataSourceConfiguration {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Value("${datasource.initialPoolSize:3}")
    private int initialPoolSize;

    @Value("${datasource.minPoolSize:1}")
    private int minPoolSize;

    @Value("${datasource.maxPoolSize:30}")
    private int maxPoolSize;

    @Value("${datasource.acquireIncrement:3}")
    private int acquireIncrement;

    @Value("${datasource.idleConnectionTestPeriod:30}")
    private int idleConnectionTestPeriod;

    @Bean(name = "datasourcecamelo")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(this.dataSourceProperties.getDriverClassName());
        } catch (Exception e) {
            throw new IllegalArgumentException("Driver class not in classpath?");
        }
        dataSource.setJdbcUrl(this.dataSourceProperties.getUrl());
        dataSource.setUser(this.dataSourceProperties.getUsername());
        dataSource.setPassword(this.dataSourceProperties.getPassword());
        System.out.println(this.dataSourceProperties.getName());
        dataSource.setInitialPoolSize(this.initialPoolSize);
        dataSource.setDataSourceName(this.dataSourceProperties.getName());
        dataSource.setMinPoolSize(this.minPoolSize);
        dataSource.setMaxPoolSize(this.maxPoolSize);
        dataSource.setAcquireIncrement(this.acquireIncrement);
        dataSource.setIdleConnectionTestPeriod(this.idleConnectionTestPeriod);
        dataSource.setPreferredTestQuery("SELECT 1");
        dataSource.setTestConnectionOnCheckin(true);
        dataSource.setTestConnectionOnCheckout(false);
        return dataSource;
    }
}
