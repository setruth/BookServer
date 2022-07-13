package com.setruth.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.multipart.MultipartResolver
import org.springframework.web.multipart.support.StandardServletMultipartResolver
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Configuration
@ComponentScan("com.setruth.controller","com.setruth.config")
@EnableWebMvc


open class SpringMVC{

}