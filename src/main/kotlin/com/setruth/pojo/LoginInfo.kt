package com.setruth.pojo

class LoginInfo {
     lateinit var account: String
     lateinit var password: String
    override fun toString(): String {
        return "LoginInfo(account='$account', password='$password')"
    }

}