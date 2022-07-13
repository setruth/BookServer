package com.setruth.utils

import org.springframework.stereotype.Service
import sun.misc.BASE64Decoder
import sun.misc.BASE64Encoder
import java.util.Base64.Encoder


object BASE64 {
    /**
     * TODO 转码
     *
     * @param text 加密文本
     * @return
     */
    fun encoder(text: String): String = BASE64Encoder().run {
        encode(text.toByteArray())
    }

    /**
     * TODO 解码
     *
     * @param text 解码文本
     * @return
     */
    fun decoder(text: String): String = String(BASE64Decoder().run {
        decodeBuffer(text)
    })
}