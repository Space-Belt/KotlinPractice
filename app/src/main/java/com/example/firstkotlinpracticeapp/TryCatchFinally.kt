package com.example.firstkotlinpracticeapp

fun main() {
    val number: Int
    println("숫자를 입력해주세요")
    try {
        val number = readlnOrNull()?.toInt()
        println("$number 입력됨")
    } catch (e: Exception) {
        println("에러발생했습니다.")
        println(e.message)
    } finally {
        println("에러 상관없이 실행됨")
        number = 0
    }


}