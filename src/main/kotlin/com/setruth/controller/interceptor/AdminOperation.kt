package com.setruth.controller.interceptor

import com.setruth.exception.SystemException
import com.setruth.pojo.ResStatusCode
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import java.lang.NullPointerException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AdminOperation : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val token = request.getHeader("token")
        println(token)
        return if (token == null) {
            throw SystemException(ResStatusCode.NOT_HAVE_TOKEN, "没有token", NullPointerException())
        } else {
            true
        }
    }
}