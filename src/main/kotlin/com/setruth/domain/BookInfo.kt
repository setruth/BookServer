package com.setruth.domain


class  BookInfo() {
    var id: Int = 0
    var bookName: String=""
    var author: String=""
    var issueDate: Long = 0
    var classification: String = ""
    var issuePosition: String = ""
    var briefContent: String = ""
    var wordsNumber: Int = 0
    var read: Int? = null
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
        read: Int?,
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