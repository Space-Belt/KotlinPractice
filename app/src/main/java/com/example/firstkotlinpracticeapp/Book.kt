package com.example.firstkotlinpracticeapp


fun main() {
    val myBook = BookClass()
    println("MyBook - Title: ${myBook.title}, Author: ${myBook.author}, Year: ${myBook.yearPublished}")

    val customBook = BookClass(title = "게츠비", author = "스캇", yearPublished = 1925)
    println("CustomBook - Title: ${customBook.title}, Author: ${customBook.author}, Year: ${customBook.yearPublished}")
}