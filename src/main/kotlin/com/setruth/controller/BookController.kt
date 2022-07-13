package com.setruth.controller

import com.setruth.domain.BookInfo
import com.setruth.pojo.ResStatusCode
import com.setruth.pojo.Result
import com.setruth.service.impl.BookServiceImpl
import com.setruth.utils.BASE64
import com.setruth.utils.JWTUtil

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileInputStream
import javax.servlet.http.HttpServletResponse

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("book")
class BookController {
    @Autowired
    private lateinit var bookServiceImpl: BookServiceImpl
    @Autowired
    lateinit var jwtUtil: JWTUtil

    var url="E:/bookServerImg/"
    /**
     * TODO 保存新的书籍信息
     *
     * @param bookInfo 新的数据信息
     * @return  处理结果
     */
    @PostMapping
    fun save(@RequestHeader(value = "token") token:String,@RequestBody bookInfo: BookInfo):Result{
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
    fun update(@RequestHeader(value = "token") token:String,@RequestBody bookInfo: BookInfo): Result{
        println(bookInfo.toString())
        return if (bookServiceImpl.update(bookInfo)){
            Result(ResStatusCode.UPDATE_OK,"操作成功",null)
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
    fun delete(@RequestHeader(value = "token") token:String, @PathVariable id: Int):Result{
        jwtUtil.validateToken(token)
        return if (bookServiceImpl.delete(id)){
            bookServiceImpl.resetId()
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
    @GetMapping("/all")
    fun getAll(): Result{
        val all = bookServiceImpl.getAll()
        return if (all!=null){
            Result(ResStatusCode.GET_ALL_OK,"操作成功",all)
        }else{
            Result(ResStatusCode.GET_ALL_ERROR,"操作失败",null)
        }
    }

    /**
     * TODO 获取书本的数量
     *
     * @return
     */
    @GetMapping("bookBrieflyStatistics")
    fun getBookCount():Result{
        val all = bookServiceImpl.getAll()
        val res= hashMapOf<String,Any>()
        res["count"] = all.size
        res["classificationCount"]=bookServiceImpl.getClassification(all)
        return Result(200,"查询成功",res)
    }

    /**
     * TODO 获取封面
     *
     * @param coverName
     */
    @GetMapping("coverImg/{coverName}")
    fun getCoverImg(@PathVariable coverName:String, response: HttpServletResponse){
        val deCoverName= BASE64.decoder(coverName)
        val file= File(url+deCoverName)
        val fileInputStream=FileInputStream(file)
        response.contentType="image/jpg"
        val outStream=response.outputStream
        outStream.write(fileInputStream.readBytes())
        outStream.flush()
        outStream.close()
    }


    @PostMapping("coverImg")
    fun updateCoverImg(@RequestParam(value="file",required=false) coverImg:MultipartFile?){
        if (coverImg != null) {
            println(coverImg.name)
            println(coverImg.size)
            println(coverImg.bytes)
            println(coverImg.contentType)
        }
    }
}