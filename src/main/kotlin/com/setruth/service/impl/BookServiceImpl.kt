package com.setruth.service.impl

import com.setruth.dao.BookDao
import com.setruth.domain.BookInfo
import com.setruth.exception.SystemException
import com.setruth.pojo.ResStatusCode
import com.setruth.service.BookService
import org.springframework.beans.factory.annotation.Autowired
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
        return bookDao.getById(id)
    }

    override fun getAll(): MutableList<BookInfo> =bookDao.getAll()

}