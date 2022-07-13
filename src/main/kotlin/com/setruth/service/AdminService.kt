package com.setruth.service

import com.setruth.domain.AdminInfo
import com.setruth.pojo.LoginInfo
import javax.print.DocFlavor.STRING

interface AdminService {
    /**
     * TODO 登录验证
     *
     * @param loginInfo 登录信息
     * @return 返回登录成功的token 如果登录失败返回null
     */
    fun login(loginInfo: LoginInfo):String?

    /**
     * TODO 修改密码
     *
     * @param id 管理员id
     * @param newPwd 新密码
     * @return
     */

    fun changePwd(id:Int,newPwd:String):Boolean


    /**
     * TODO 根据id获取用户信息
     *
     * @param id
     * @return
     */
     fun getInfoById(id:Int):AdminInfo?

    /**
     * TODO 更新登录时间
     *
     * @param id
     * @return
     */
    fun updateLoginTime(id:Int):Boolean
}