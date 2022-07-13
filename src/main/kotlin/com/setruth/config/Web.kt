package com.setruth.config

import org.springframework.web.filter.CharacterEncodingFilter
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
import javax.servlet.Filter
import javax.servlet.MultipartConfigElement
import javax.servlet.ServletRegistration

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

    override fun customizeRegistration(registration: ServletRegistration.Dynamic) {
        val location = "E://bookServerImg//"
        registration.setMultipartConfig(MultipartConfigElement(location))
    }
}