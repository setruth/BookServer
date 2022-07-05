package com.setruth.controller

import com.setruth.domain.BookInfo
import com.setruth.pojo.ResStatusCode
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

    /**
     * TODO 保存新的书籍信息
     *
     * @param bookInfo 新的数据信息
     * @return  处理结果
     */
    @PostMapping
    fun save(@RequestBody bookInfo: BookInfo):Result{
        val res=bookServiceImpl.update(bookInfo)
        return if (res){
            Result(ResStatusCode.SAVE_OK,"操作成功",null)
        }else{
            Result(ResStatusCode.SAVE_ERROR,"操作失败",null)
        }
    }

    /**
     * TODO 更新书本信息
     *
     * @param bookInfo 新的书本信息
     * @return 返回处理结果
     */
    @PutMapping
    fun update(@RequestBody bookInfo: BookInfo): Result{
        return if (bookServiceImpl.update(bookInfo)){
            Result(ResStatusCode.UPDATE_OK,"操作成",null)
        }else{
            Result(ResStatusCode.UPDATE_ERROR,"操作失败",null)
        }
    }

    /**
     * TODO 删除书籍信息
     *
     * @param id 书籍的id
     * @return
     */
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int):Result{
        return if (bookServiceImpl.delete(id)){
            Result(ResStatusCode.DEL_OK,"操作成功",null)
        }else{
            Result(ResStatusCode.DEL_ERROR,"操作失败",null)
        }
    }

    /**
     * TODO 根据id获取书籍信息
     *
     * @param id 书籍的id
     * @return
     */
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): Result{
        val book = bookServiceImpl.getById(id)
        return if (book!=null){
            Result(ResStatusCode.GET_BY_ID_OK,"操作成功",book)
        }else{
            Result(ResStatusCode.GET_BY_ID_ERROR,"操作失败",null)
        }
    }

    /**
     * TODO 获取全部的书籍
     *
     * @return
     */
    @GetMapping
    fun getAll(): Result{
        val all = bookServiceImpl.getAll()
        return if (all!=null){
            Result(ResStatusCode.GET_ALL_OK,"操作成功",all)
        }else{
            Result(ResStatusCode.GET_ALL_ERROR,"操作失败",null)
        }
    }
}