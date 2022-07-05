package com.setruth.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.TokenExpiredException
import com.setruth.exception.TokenException
import com.setruth.pojo.JWTConfig
import com.setruth.pojo.ResStatusCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class JWTUtil {
    @Autowired
    lateinit var jwtConfig:JWTConfig
    fun createToken(id:String):String{
        return  jwtConfig.tokenPrefix + JWT.create()
            .withJWTId(id)
            .withIssuer(jwtConfig.playLoadIss)
            .withExpiresAt(Date(System.currentTimeMillis()+jwtConfig.playLoadExpireTime))
            .sign(Algorithm.HMAC256(jwtConfig.secret))
    }
    fun validateToken(token:String):Int{
       try {
           val id = JWT.require(Algorithm.HMAC256(jwtConfig.secret))
               .build()
               .verify(token.replace(jwtConfig.tokenPrefix,""))
               .id
           return id.toInt()
       }catch (e:TokenExpiredException){
           throw TokenException(ResStatusCode.TOKEN_IS_OVERDUE,"token过期",e)
       }catch (e:Exception){
           throw TokenException(ResStatusCode.TOKEN_VALIDATE_ERROR,"token认证失败",e)
       }

    }
}