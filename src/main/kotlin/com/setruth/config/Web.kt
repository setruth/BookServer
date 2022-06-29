package com.setruth.config

import org.springframework.web.filter.CharacterEncodingFilter
import org.springframework.web.servlet.support.*
import javax.servlet.Filter

class Web :AbstractAnnotationConfigDispatcherServletInitializer() {
    override fun getServletMappings(): Array<String> = arrayOf("/")

    override fun getRootConfigClasses(): Array<Class<*>>? {
        return arrayOf(Spring::class.java)
    }

    override fun getServletConfigClasses(): Array<Class<*>>? {
        return arrayOf(SpringMVC::class.java)
    }
    //配置过滤器 以防传过来乱码
    override fun getServletFilters(): Array<Filter>? {
        val filter= CharacterEncodingFilter()
        filter.encoding="UTF-8"
        return arrayOf(filter)
    }
}