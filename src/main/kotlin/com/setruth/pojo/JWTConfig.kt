package com.setruth.pojo

class JWTConfig {
    //header配置
    lateinit var headerType: String
    lateinit var headerAlg: String

    // playLoad配置
    lateinit var playLoadIss: String
    var expireTime: Int = 0
    //加密密钥
    lateinit var secret:String

}