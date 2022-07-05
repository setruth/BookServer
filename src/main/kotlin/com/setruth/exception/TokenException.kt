package com.setruth.exception

import org.springframework.remoting.RemoteTimeoutException
import java.util.concurrent.TimeoutException

class TokenException(status:Int, msg: String, cause: Throwable) : RemoteTimeoutException(msg, cause) {
    var status:Int=0
    init {
        this.status=status
    }
}