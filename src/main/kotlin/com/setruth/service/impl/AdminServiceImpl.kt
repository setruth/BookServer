package com.setruth.service.impl

import com.setruth.dao.AdminDao
import com.setruth.pojo.LoginInfo
import com.setruth.service.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AdminServiceImpl : AdminService {
    @Autowired
    lateinit var adminDao:AdminDao
    override fun login(loginInfo: LoginInfo): String? {
        val res = adminDao.findByAccount(loginInfo.account)
        return if (res==null){
            null
        }else
            "ok"
    }

    override fun changePwd(token: String, id: Int, newPwd: String): Boolean {
        val res = adminDao.changePwd(id, newPwd)
        return res
    }

    override fun getToken(id: Int): String {
        return "123"
    }

    override fun judgeToken(token: String): Boolean {
        return true
    }


}