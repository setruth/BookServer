package com.setruth.service

import com.setruth.domain.BookInfo


interface BookService {
    /**
     * TODO 保存
     *
     * @param bookInfo
     * @return 是否成功
     */
    fun save(bookInfo: BookInfo):Boolean

    /**
     * TODO 更新
     *
     * @param bookInfo
     * @return 是否成功
     */
    fun update(bookInfo: BookInfo):Boolean

    /**
     * TODO 删除
     *
     * @param id 要删除的id
     * @return 是否成功
     */
    fun delete(id: Int):Boolean

    /**
     * TODO 获取信息根据id
     *
     * @param id 要获取的数据id
     * @return
     */
    fun getById(id: Int): BookInfo?

    /**
     * TODO 获取全部
     *
     * @return 全部的数据
     */
    fun getAll(): MutableList<BookInfo>?

    /**
     * TODO 获取书籍的数量
     *
     */
    fun getBookCount():Int

    /**
     * TODO 获取书本分类信息
     *
     * @param bookList
     * @return
     */
    fun getClassification(bookList:MutableList<BookInfo>):MutableMap<String,Int>
    /**
     * TODO 重置自增的id
     *
     */
    fun resetId()
}