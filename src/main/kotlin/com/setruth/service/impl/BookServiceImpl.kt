package com.setruth.service.impl

import com.setruth.dao.BookDao
import com.setruth.domain.BookInfo
import com.setruth.exception.SystemException
import com.setruth.pojo.DaoResStatusConst
import com.setruth.service.BookService
import jdk.net.SocketFlow.Status
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class BookServiceImpl :BookService {
    @Autowired
    lateinit var bookDao:BookDao
    override fun save(bookInfo: BookInfo): Boolean {
        bookDao.save(bookInfo)
        return true
    }

    override fun update(bookInfo: BookInfo): Boolean {
        bookDao.update(bookInfo)
        return true
    }

    override fun delete(id: Int): Boolean {
        bookDao.delete(id)
        return true
    }

    override fun getById(id: Int): BookInfo{
        try {
            var i=1/0
        }catch (e:Exception){
            throw SystemException(DaoResStatusConst.GET_BY_ID_ERROR,"查询错误",e)
        }
        return bookDao.getById(id)
    }

    override fun getAll(): MutableList<BookInfo> =bookDao.getAll()

}