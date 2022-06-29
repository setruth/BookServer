package com.setruth.controller

import com.setruth.domain.BookInfo
import com.setruth.pojo.DaoResStatusConst
import com.setruth.pojo.Result
import com.setruth.service.impl.BookServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("book")
class BookController {
    @RequestMapping("test")
    fun test():String{
        return "Ok"
    }
    @Autowired
    private lateinit var bookServiceImpl: BookServiceImpl

    @PostMapping
    fun save(@RequestBody bookInfo: BookInfo):Result{
        val res=bookServiceImpl.update(bookInfo)
        return if (res){
            Result(DaoResStatusConst.SAVE_OK,"操作成功",null)
        }else{
            Result(DaoResStatusConst.SAVE_ERROR,"操作失败",null)
        }
    }

    @PutMapping
    fun update(@RequestBody bookInfo: BookInfo): Result{
        return if (bookServiceImpl.update(bookInfo)){
            Result(DaoResStatusConst.UPDATE_OK,"操作成",null)
        }else{
            Result(DaoResStatusConst.UPDATE_ERROR,"操作失败",null)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int):Result{
        return if (bookServiceImpl.delete(id)){
            Result(DaoResStatusConst.DEL_OK,"操作成功",null)
        }else{
            Result(DaoResStatusConst.DEL_ERROR,"操作失败",null)
        }
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): Result{
        val book = bookServiceImpl.getById(id)
        return if (book!=null){
            Result(DaoResStatusConst.GET_BY_ID_OK,"操作成功",book)
        }else{
            Result(DaoResStatusConst.GET_BY_ID_ERROR,"操作失败",null)
        }
    }

    @GetMapping
    fun getAll(): Result{
        val all = bookServiceImpl.getAll()
        return if (all!=null){
            Result(DaoResStatusConst.GET_ALL_OK,"操作成功",all)
        }else{
            Result(DaoResStatusConst.GET_ALL_ERROR,"操作失败",null)
        }
    }
}