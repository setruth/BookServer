package com.setruth.config

import com.setruth.pojo.JWTConfig
import org.springframework.context.annotation.*


@Configuration
@ComponentScan("com.setruth.service")
@Import(Mybatis::class,JWT::class)
open class Spring {


    @Bean
    open fun getJWTConfig():JWTConfig{
        return JWTConfig().apply {

        }
    }
}