package com.setruth.config

import com.setruth.controller.interceptor.AdminInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

@Configuration
open class SpringMvcSupport : WebMvcConfigurationSupport()
{
    @Autowired
    lateinit var adminInterceptor:AdminInterceptor
    
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/*").excludePathPatterns("/admin/login","admin/register")
    }
}