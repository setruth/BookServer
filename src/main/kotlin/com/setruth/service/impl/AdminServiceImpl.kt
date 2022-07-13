package com.setruth.service.impl

import com.setruth.dao.AdminDao
import com.setruth.domain.AdminInfo
import com.setruth.pojo.LoginInfo
import com.setruth.service.AdminService
import com.setruth.utils.JWTUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AdminServiceImpl : AdminService {
    @Autowired
    lateinit var adminDao: AdminDao
    @Autowired
    lateinit var jwtUtil: JWTUtil

    override fun login(loginInfo: LoginInfo): String? {
        val res = adminDao.findByAccount(loginInfo.account)
        return if (res == null) {
            null
        } else{
            if (loginInfo.password==res.password){
                return jwtUtil.createToken(res.id.toString())
            }else{
                return null
            }
        }
    }

    override fun changePwd(id: Int, newPwd: String): Boolean = adminDao.changePwd(id, newPwd)

    override fun getInfoById(id: Int): AdminInfo? =adminDao.getInfoById(id)

    override fun updateLoginTime(id: Int): Boolean {
        val nowTime = System.currentTimeMillis()
        return adminDao.updateLoginTime(id,nowTime)
    }

}