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
     * @param token token令牌
     * @param id 管理员id
     * @param newPwd 新密码
     * @return
     */

    fun changePwd(token:String,id:Int,newPwd:String):Boolean

    /**
     * TODO 获取账户token
     *
     * @param id 账户的id
     * @return
     */
    fun getToken(id: Int):String

    /**
     * TODO 判断token是否过期
     *
     * @param token
     * @return true过期，false没有过期
     */
    fun judgeToken(token:String):Boolean

    /**
     * TODO 根据id获取用户信息
     *
     * @param id
     * @return
     */
     fun getInfoById(id:Int):AdminInfo?

}