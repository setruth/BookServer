package com.setruth.controller

import com.setruth.domain.BookInfo
import com.setruth.pojo.ResStatusCode
import com.setruth.pojo.Result
import com.setruth.service.impl.BookServiceImpl
import com.setruth.utils.BASE64
import com.setruth.utils.JWTUtil
import org.apache.commons.fileupload.FileUploadException

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import javax.servlet.http.HttpServletResponse

@CrossOrigin(origins = ["*"], maxAge = 3600)
@RestController
@RequestMapping("book")
class BookController {
    @Autowired
    private lateinit var bookServiceImpl: BookServiceImpl

    @Autowired
    lateinit var jwtUtil: JWTUtil

    private var coverImgUrl = "E:/bookServerImg/"

    /**
     * TODO 保存新的书籍信息
     *
     * @param bookInfo 新的数据信息
     * @return  处理结果
     */
    @PostMapping
    fun save(@RequestHeader(value = "token") token: String, @RequestBody bookInfo: BookInfo): Result {
        bookServiceImpl.resetId()
        val res = bookServiceImpl.save(bookInfo)
        return if (res) {
            Result(ResStatusCode.SAVE_OK, "操作成功",bookInfo )
        } else {
            Result(ResStatusCode.SAVE_ERROR, "操作失败", null)
        }
    }

    /**
     * TODO 更新书本信息
     *
     * @param bookInfo 新的书本信息
     * @return 返回处理结果
     */
    @PutMapping
    fun update(@RequestHeader(value = "token") token: String, @RequestBody bookInfo: BookInfo): Result {
        println(bookInfo.toString())
        return if (bookServiceImpl.update(bookInfo)) {
            Result(ResStatusCode.UPDATE_OK, "操作成功", bookInfo)
        } else {
            Result(ResStatusCode.UPDATE_ERROR, "操作失败", null)
        }
    }

    /**
     * TODO 删除书籍信息
     *
     * @param id 书籍的id
     * @return
     */
    @DeleteMapping("/{id}")
    fun delete(@RequestHeader(value = "token") token: String, @PathVariable id: Int): Result {
        jwtUtil.validateToken(token)
        bookServiceImpl.resetId()
        return if (bookServiceImpl.delete(id)) {

            Result(ResStatusCode.DEL_OK, "操作成功", null)
        } else {
            Result(ResStatusCode.DEL_ERROR, "操作失败", null)
        }
    }

    /**
     * TODO 根据id获取书籍信息
     *
     * @param id 书籍的id
     * @return
     */
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): Result {
        val book = bookServiceImpl.getById(id)
        return if (book != null) {
            Result(ResStatusCode.GET_BY_ID_OK, "操作成功", book)
        } else {
            Result(ResStatusCode.GET_BY_ID_ERROR, "操作失败", null)
        }
    }

    /**
     * TODO 获取全部的书籍
     *
     * @return
     */
    @GetMapping("/all")
    fun getAll(): Result {
        val all = bookServiceImpl.getAll()
        return if (all != null) {
            Result(ResStatusCode.GET_ALL_OK, "操作成功", all)
        } else {
            Result(ResStatusCode.GET_ALL_ERROR, "操作失败", null)
        }
    }

    /**
     * TODO 获取书本的数量
     *
     * @return
     */
    @GetMapping("bookBrieflyStatistics")
    fun getBookCount(): Result {
        val all = bookServiceImpl.getAll()
        val res = hashMapOf<String, Any>()
        res["count"] = all.size
        res["classificationCount"] = bookServiceImpl.getClassification(all)
        return Result(200, "查询成功", res)
    }

    /**
     * TODO 获取封面
     *
     * @param coverName
     */
    @GetMapping("coverImg/{coverName}/{temp}")
    fun getCoverImg(@PathVariable coverName: String, response: HttpServletResponse) {
        val deCoverName = BASE64.decoder(coverName)
        val file = File(coverImgUrl + deCoverName)
        val fileInputStream = FileInputStream(file)
        response.contentType = "image/jpg"
        val outStream = response.outputStream
        outStream.write(fileInputStream.readBytes())
        outStream.flush()
        outStream.close()
        fileInputStream.close()
    }

    /**
     * TODO 更新封面
     *
     * @param token
     * @param coverImg
     * @param id
     * @return
     */
    @PostMapping("coverImg")
    fun updateCoverImg(
        @RequestHeader("token") token: String,
        @RequestParam(value = "file", required = false) coverImg: MultipartFile?,
        @RequestParam(value = "id", required = false) id: Int,
    ): Result {
        jwtUtil.validateToken(token)
        if (coverImg != null) {
            val encoderFileName = BASE64.encoder(id.toString())
            println(encoderFileName+"${id}")
            bookServiceImpl.updateCoverImg(id, encoderFileName)
            val file = File(File(coverImgUrl).absolutePath + "/" + id)
            if (file.parentFile.exists()) {
                file.parentFile.mkdir()
            }
            return try {
                coverImg.transferTo(file)
                Result(ResStatusCode.UPDATE_COVER_IMG_OK, "封面更新成功", encoderFileName)
            } catch (e: IOException) {
                file.delete()
                val file1 = File(File(coverImgUrl).absolutePath + "/" + id)
                try {
                    coverImg.transferTo(file1)
                    Result(ResStatusCode.UPDATE_COVER_IMG_OK, "封面更新成功", encoderFileName)
                } catch (e: Exception) {
                    Result(ResStatusCode.UPDATE_COVER_IMG_ERROR, "封面更新失败", null)
                }
            } catch (e: Exception) {
                Result(ResStatusCode.UPDATE_COVER_IMG_ERROR, "封面更新失败", null)
            }

        } else {
            return Result(ResStatusCode.NOT_FOUND_COVER_IMG, "找不到封面", null)
        }
    }

}