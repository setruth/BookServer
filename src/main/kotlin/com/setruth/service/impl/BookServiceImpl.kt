package com.setruth.service.impl

import com.setruth.dao.BookDao
import com.setruth.domain.BookInfo
import com.setruth.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl :BookService {
    @Autowired
    lateinit var bookDao:BookDao
    override fun save(bookInfo: BookInfo): Boolean {
        bookDao.addBook(bookInfo)
        return true
    }

    override fun update(bookInfo: BookInfo): Boolean {
        bookDao.updateBookInfo(bookInfo)
        return true
    }

    override fun delete(id: Int): Boolean {
        bookDao.deleteBookById(id)
        return true
    }

    override fun getById(id: Int): BookInfo{
        return bookDao.getById(id)
    }

    override fun getAll(): MutableList<BookInfo> =bookDao.getAll()
    override fun getBookCount()=bookDao.getAll().size
    override fun getClassification(bookList: MutableList<BookInfo>): MutableMap<String, Int> {
        val map= mutableMapOf<String,Int>()
        bookList.forEach {
            if (map[it.classification] ==null){
                map[it.classification] = 1
            }else{
                map[it.classification]= map[it.classification]!! +1
            }
        }
        return map
    }

    override fun resetId() {
        bookDao.resetId()
    }
}