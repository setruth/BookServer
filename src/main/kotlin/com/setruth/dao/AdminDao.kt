package com.setruth.dao

import com.setruth.domain.AdminInfo
import com.setruth.domain.BookInfo
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper

interface AdminDao {
    /**
     * TODO 查询管理员账户是否在数据库中
     *
     * @param account 查询的账户信息
     * @return 返回结果，如果为null 则是没有此人的信息
     */
    @Select("select * from admin where account = #{account}")
    fun findByAccount(account:String):AdminInfo?

    /**
     * TODO 更新密码信息
     *
     * @param id 管理员的id
     * @param newPwd
     * @return
     */
    @Update("update admin set password = #{newPwd} where id =#{id}")
    fun changePwd(@Param("id")id:Int,@Param("newPwd") newPwd:String):Boolean

    /**
     * TODO 获取管理员信息根据id
     *
     * @param id
     * @return
     */
    @Select("select * from admin where id = #{id}")
    fun getInfoById(id:Int):AdminInfo?

    /**
     * TODO 更新登录时间
     *
     * @param time
     * @param id
     * @return
     */
    @Update("update admin set last_login_time = #{nowTime} where id = #{id}")
    fun updateLoginTime(@Param("id")id: Int,@Param("nowTime")nowTime:Long):Boolean


}