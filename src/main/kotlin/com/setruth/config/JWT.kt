package com.setruth.config

import com.setruth.pojo.JWTConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration

@PropertySource("classpath:com/setruth/config/jwt.properties")
open class JWT {
    @Value("\${tokenPrefix}")
    lateinit var tokenPrefix:String
    @Value("\${playLoad.iss}")
    lateinit var playLoadIss:String
    @Value("\${playLoad.expireTime}")
    var playTimeExpireTime:Int = 0
    @Value("\${secret}")
    lateinit var secret:String
    @Bean
    open fun createJWTConfig(): JWTConfig {
        val jwtConfig=JWTConfig()
        jwtConfig.playLoadIss=playLoadIss
        jwtConfig.playLoadExpireTime=playTimeExpireTime
        jwtConfig.secret=secret
        jwtConfig.tokenPrefix=tokenPrefix
        return jwtConfig
    }

}