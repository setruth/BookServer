package com.setruth.dao

import com.setruth.domain.BookInfo
import org.apache.ibatis.annotations.*

@Mapper
interface BookDao {

    /**
     * TODO 重置自增的id
     *
     */
    @Update("alter table book_content auto_increment=1;")
    fun resetId()

    /**
     * TODO 新增图书
     *
     * @param bookInfo
     */
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("insert into book_content values(null,#{bookName},#{author},#{issueDate},#{classification},#{issuePosition},#{briefContent},#{wordsNumber},#{read},#{imgCover})")
    fun addBook(bookInfo: BookInfo)

    /**
     * TODO 获取数据信息根据id
     *
     * @param id
     * @return
     */
    @Select("select * from book_content where id=#{id}")
    fun getById(id: Int): BookInfo

    /**
     * TODO 获取所有的书籍信息
     *
     * @return
     */
    @Select("select * from book_content")
    fun getAll(): MutableList<BookInfo>

    /**
     * TODO 根据id删除图书信息
     *
     * @param id
     * @return
     */
    @Delete("delete from book_content where id=#{id} ")
    fun deleteBookById(id: Int): Boolean
//    alter table sys_user auto_increment=1;
    /**
     * TODO 更新书本信息
     *
     * @param bookInfo
     * @return
     */
    @Update("update book_content set  bookName=#{bookName},author=#{author},issueDate=#{issueDate},classification=#{classification},issuePosition=#{issuePosition},briefContent=#{briefContent},wordsNumber=#{wordsNumber} where id=#{id}")
    fun updateBookInfo(bookInfo: BookInfo): Boolean

    /**
     * TODO 更新封面图片
     *
     * @param id
     * @param coverImg
     */
    @Update("update book_content set imgCover=#{coverImg} where id=#{id}")
    fun updateBookCoverImg(@Param("id") id:Int,@Param("coverImg") coverImg:String)
}