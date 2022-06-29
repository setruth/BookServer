package com.setruth.controller

import com.setruth.exception.SystemException
import com.setruth.pojo.Result
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException::class)
    fun doException(e:SystemException): Result {
        return Result(e.status, e.message!!,null)
    }
}