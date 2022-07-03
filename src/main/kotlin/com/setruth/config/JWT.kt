package com.setruth.config

import com.setruth.pojo.JWTConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration


open class JWT {

    @Bean
    open fun createJWTConfig(): JWTConfig {
        return JWTConfig().apply {

        }

    }

}