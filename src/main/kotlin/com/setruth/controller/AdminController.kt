package com.setruth.controller

import com.setruth.domain.AdminInfo
import com.setruth.pojo.LoginInfo
import com.setruth.pojo.ResStatusCode
import com.setruth.pojo.Result
import com.setruth.service.AdminService
import com.setruth.service.impl.AdminServiceImpl
import com.setruth.utils.JWTUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = arrayOf("*"), maxAge = 3600)
@RestController
@RequestMapping("admin")
class AdminController {

    @Autowired
    lateinit var adminServiceImpl: AdminServiceImpl
    @Autowired
    lateinit var jwtUtil: JWTUtil

    @ResponseBody
    @PostMapping("login")
    fun login(@RequestBody loginInfo: LoginInfo):Result{
        val res = adminServiceImpl.login(loginInfo)
        return if (res==null){
            Result(ResStatusCode.LOGIN_ERROR,"登录失败,请检查账号密码",null)
        }else{
            Result(ResStatusCode.LOGIN_OK,"登录成功",res)
        }
    }

    @GetMapping
    fun  getAdminInfo(@RequestHeader(value = "token") token:String):Result {
        val id = jwtUtil.validateToken(token)
        val info = adminServiceImpl.getInfoById(id)
        val resInfo= mutableMapOf<String,Any>()
        return if (info==null){
            Result(ResStatusCode.FIND_INFO_ERROR,"找不到用户信息，查询失败",null)
        }else{
            resInfo.put("account",info.account)
            resInfo.put("last_login_time",info.lastLoginTime)
            Result(ResStatusCode.FIND_INFO_OK,"查询成功",resInfo)
        }
    }

    @GetMapping("test")
    fun adminTest():String{
        return "ok"
    }

}