package com.setruth.domain

class  BookInfo(
    var id: Int,
    var bookName: String,
    var author: String,
    var issueDate: Int,
    var update: Int,
    var issuePosition: String,
    var briefContent: String,
    var wordsNumber: Int
) {
    var coverImg:Int=0
    override fun toString(): String {
        return "BookInfo(id=$id, bookName='$bookName', author='$author', issueDate=$issueDate, update=$update, issuePosition='$issuePosition', briefContent='$briefContent', wordsNumber=$wordsNumber, coverImg=$coverImg)"
    }
}