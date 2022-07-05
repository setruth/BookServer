package com.setruth.dao

import com.setruth.domain.BookInfo
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Component

@Mapper
interface BookDao {

    /**
     * TODO 新增图书
     *
     * @param bookInfo
     */
    @Insert("insert into book_content values(null,#{bookName},#{author},#{issueDate},#{update},#{issuePosition},#{briefContent},#{wordsNumber},#{coverImg})")
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
    fun deleteBookById(id:Int):Boolean

    /**
     * TODO 更新书本信息
     *
     * @param bookInfo
     * @return
     */
    @Update("update book_content set  where book_name=#{bookName},author=#{author},issue_date=#{issueDate},update_date=#{updateDate},issue_position=#{issuePosition},brief_content=#{briefContent},words_number=#{wordsNumber},cover_img=#{coverImg} where id=#{id}")
    fun updateBookInfoById(bookInfo: BookInfo):Boolean

}