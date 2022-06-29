package com.setruth.dao

import com.setruth.domain.BookInfo
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Component

@Component
@Mapper
interface BookDao {
    @Insert("insert into book_content values(null,#{bookName},#{author},#{issueDate},#{update},#{issuePosition},#{briefContent},#{wordsNumber},#{coverImg})")
    fun save(bookInfo: BookInfo)
    fun update(bookInfo: BookInfo)
    @Delete("delete from book_content where id=#{id}")
    fun delete(id: Int)
    @Select("select * from book_content where id=#{id}")
    fun getById(id: Int): BookInfo
    @Select("select * from book_content")
    fun getAll(): MutableList<BookInfo>
}