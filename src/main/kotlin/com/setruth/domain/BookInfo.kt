package com.setruth.domain


class  BookInfo() {
    var id: Int = 0
    var bookName: String?=null
    var author: String?=null
    var issueDate: Long = 0
    var classification: String=""
    var issuePosition: String?=null
    var briefContent: String?=null
    var wordsNumber: Int?=null
    var read: Int = 0
    var imgCover: String? = null

    constructor(
        id: Int,
        bookName: String,
        author: String,
        issueDate: Long,
        classification: String,
        issuePosition: String,
        briefContent: String,
        wordsNumber: Int,
        read: Int,
        imgCover: String?
    ) : this() {
        this.id = id
        this.bookName = bookName
        this.author = author
        this.issueDate = issueDate
        this.classification = classification
        this.issuePosition = issuePosition
        this.briefContent = briefContent
        this.wordsNumber = wordsNumber
        this.read = read
        this.imgCover = imgCover
    }

    override fun toString(): String {
        return "BookInfo(id=$id, bookName='$bookName', author='$author', issueDate=$issueDate, update=$classification, issuePosition='$issuePosition', briefContent='$briefContent', wordsNumber=$wordsNumber,read=$read )"
    }
}