package com.setruth.pojo

class JWTConfig {
    // playLoad配置
    lateinit var playLoadIss: String
    var playLoadExpireTime: Int = 0
    //加密密钥
    lateinit var secret:String
    //前缀
    lateinit var tokenPrefix:String
}