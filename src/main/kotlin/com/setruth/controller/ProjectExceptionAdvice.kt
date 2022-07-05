package com.setruth.controller

import com.setruth.exception.SystemException
import com.setruth.exception.TokenException
import com.setruth.pojo.Result
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException::class)
    fun systemException(e:SystemException): Result = Result(e.status, e.message!!,null)
    @ExceptionHandler(TokenException::class)
    fun tokenException(e:TokenException):Result=Result(e.status, e.message!!,null)

}