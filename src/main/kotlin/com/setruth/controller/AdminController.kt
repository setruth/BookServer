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

@CrossOrigin
@RestController
@RequestMapping("admin")
class AdminController {

    @Autowired
    lateinit var adminServiceImpl: AdminServiceImpl

    @Autowired
    lateinit var jwtUtil: JWTUtil

    /**
     * TODO 登录
     *
     * @param loginInfo
     * @return
     */
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
 
    /**
     * TODO 获取管理员信息
     *
     * @param token
     * @return
     */
    @GetMapping
    fun  getAdminInfo(@RequestHeader(value = "token") token:String):Result {
        val id = jwtUtil.validateToken(token)
        val info = adminServiceImpl.getInfoById(id)
        val resInfo= mutableMapOf<String,Any>()

        return if (info==null){
            Result(ResStatusCode.FIND_INFO_ERROR,"找不到用户信息，查询失败",null)
        }else{
            resInfo["account"] = info.account
            resInfo["last_login_time"] = info.lastLoginTime
            Result(ResStatusCode.FIND_INFO_OK,"查询成功",resInfo)
        }
    }

    /**
     * TODO 修改密码
     *
     * @param token
     * @param newPwd
     * @return
     */
    @PutMapping
    fun changePwd(@RequestHeader(value = "token") token:String, @RequestBody newPwd:String):Result{
        val id = jwtUtil.validateToken(token)
        val res = adminServiceImpl.changePwd(id, newPwd)
        if (res){
            return Result(ResStatusCode.CHANGE_PWD_OK,"修改密码成功",null)
        }else{
            return Result(ResStatusCode.CHANGE_PWD_ERROR,"修改失败",null)

        }
    }

    /**
     * TODO 更新Token
     *
     * @param token
     * @return
     */
    @PutMapping("/token")
    fun updateToken(@RequestHeader(value = "token") token:String):Result{
        val id = jwtUtil.validateToken(token)
       return Result(ResStatusCode.UPDATE_TOKEN_OK,"更新token成功",jwtUtil.createToken(id.toString()))

    }

    /**
     * TODO 更新登录时间
     *
     * @param token
     * @return
     */
    @PutMapping("/loginTime")
    fun updateLoginTime(@RequestHeader(value = "token") token:String):Result{
        val id = jwtUtil.validateToken(token)
        adminServiceImpl.updateLoginTime(id)
        return Result(ResStatusCode.UPDATE_LOGIN_TIME_OK,"更新成功",null)
    }

}