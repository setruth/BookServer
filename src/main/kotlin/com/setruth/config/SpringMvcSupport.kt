package com.setruth.config

import com.setruth.controller.interceptor.AdminOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

@Configuration
open class SpringMvcSupport : WebMvcConfigurationSupport() {
    @Autowired
    lateinit var adminOperation: AdminOperation

    override fun addInterceptors(registry: InterceptorRegistry) {
    }


}