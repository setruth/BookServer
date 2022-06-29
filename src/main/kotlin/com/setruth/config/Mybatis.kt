package com.setruth.config

import com.alibaba.druid.pool.DruidDataSource
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.mapper.MapperScannerConfigurer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import java.sql.Driver
import javax.sql.DataSource

@Configuration
open class Mybatis {


    @Bean
    open fun dataSource():DataSource {
        val druidDataSource= DruidDataSource()
        println("jdbc驱动${JdbcConfig.DRIVER}")
        druidDataSource.driverClassName=JdbcConfig.DRIVER
        println("地址${JdbcConfig.URL}")
        druidDataSource.url=JdbcConfig.URL
        println("用户名${JdbcConfig.USER_NAME}")
        druidDataSource.username=JdbcConfig.USER_NAME
        println("密码${JdbcConfig.PASSWORD}")
        druidDataSource.password=JdbcConfig.PASSWORD
        println("完成数据源对象创建")
        return druidDataSource
    }
    /**
     * TODO 创建mybatis的工程bean
     *
     * @param dataSource
     * @return
     */
    @Bean
    open fun sqlSessionFactoryBean(dataSource: DataSource): SqlSessionFactoryBean {
        val sqlSessionFactoryBean= SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(dataSource)
        println("映射表对象")
        //扫描
        sqlSessionFactoryBean.setTypeAliasesPackage("com.setruth.domain")
        println("扫描表对象完成")
        return sqlSessionFactoryBean
    }
    /**
     * TODO 扫描映射dao包下的内容创建成MapperFactoryBean
     *
     * @return
     */
    @Bean
    open fun mapperScannerConfigurer():MapperScannerConfigurer{
        val msc=MapperScannerConfigurer()
        println("扫描Dao")
        msc.setBasePackage("com.setruth.dao")
        println("映射Dao完成")
        return msc
    }
}