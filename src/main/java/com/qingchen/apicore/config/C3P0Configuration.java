package com.qingchen.apicore.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * <ClassName>C3P0Configuration</ClassName>
 * <Description></Description>
 *
 * @author Ace_Zheng
 */
@Configuration
public class C3P0Configuration {
    @Value("${driverClass}")
    private String driverClassName;
    @Value("${user}")
    private String username;
    @Value("${password}")
    private String password;
    @Value("${jdbcUrl}")
    private String url;
    /**
     * 生成c3p0连接池的bean
     * @return
     * @throws PropertyVetoException
     */
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        //创建c3p0连接池对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        /*基本配置*/
        dataSource.setDriverClass(driverClassName); //数据库驱动类
        dataSource.setUser(username); //数据库用户名
        dataSource.setPassword(password); //数据库用户密码
        dataSource.setJdbcUrl(url);//数据库连接URL
        /*配置c3p0连接池的私有属性*/
        dataSource.setMaxPoolSize(30); //连接池最大连接数
        dataSource.setMinPoolSize(10); //连接池最小连接数
        dataSource.setAutoCommitOnClose(false); //关闭连接后不自动提交
        dataSource.setCheckoutTimeout(10000); //连接超时时间
        dataSource.setAcquireRetryAttempts(2); //连接失败允许重试次数
        //返回连接池对象
        return dataSource;
    }
}
