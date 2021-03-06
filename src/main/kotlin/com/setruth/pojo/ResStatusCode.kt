package com.setruth.pojo

object ResStatusCode {
    /**
     * TODO 没有token提示
     */
    const val NOT_HAVE_TOKEN = 10000

    /**
     * TODO BookController状态码
     */
    const val SAVE_OK = 201
    const val DEL_OK = 202
    const val UPDATE_OK = 203
    const val GET_BY_ID_OK = 204
    const val GET_ALL_OK = 205
    const val UPDATE_COVER_IMG_OK = 206


    const val SAVE_ERROR = 501
    const val DEL_ERROR = 502
    const val UPDATE_ERROR = 503
    const val GET_BY_ID_ERROR = 504
    const val GET_ALL_ERROR = 505
    const val NOT_FOUND_COVER_IMG=506
    const val UPDATE_COVER_IMG_ERROR=507

    /**
     *  TODO 管理员状态码
     */
    const val LOGIN_OK = 211
    const val FIND_INFO_OK = 212
    const val CHANGE_PWD_OK = 214
    const val UPDATE_TOKEN_OK=215
    const val UPDATE_LOGIN_TIME_OK=216

    const val CHANGE_PWD_ERROR = 514
    const val FIND_INFO_ERROR = 512
    const val LOGIN_ERROR = 511
    const val TOKEN_VALIDATE_ERROR = 513
    const val TOKEN_IS_OVERDUE = 514
}