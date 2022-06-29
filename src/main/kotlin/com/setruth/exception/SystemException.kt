package com.setruth.exception

import org.springframework.remoting.RemoteTimeoutException

class SystemException(  status: Int,msg: String, cause: Throwable ) : RemoteTimeoutException(msg, cause) {
     var status:Int
    init {
        this.status=status
    }
}