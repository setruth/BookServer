package com.setruth.config

import org.springframework.context.annotation.*


@Configuration
@ComponentScan("com.setruth.service")
@Import(Mybatis::class)
open class Spring {

}