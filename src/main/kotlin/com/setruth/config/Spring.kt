package com.setruth.config

import com.setruth.pojo.JWTConfig
import org.springframework.context.annotation.*
import org.springframework.web.multipart.MultipartResolver
import org.springframework.web.multipart.support.StandardServletMultipartResolver


@Configuration
@ComponentScan("com.setruth.service","com.setruth.utils")
@Import(Mybatis::class,JWT::class)
open class Spring {


}