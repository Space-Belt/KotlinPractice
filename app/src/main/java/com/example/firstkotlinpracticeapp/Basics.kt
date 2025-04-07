package com.example.firstkotlinpracticeapp

fun first() {
    println("Hello World")
}

fun floatDouble() {
    var pi = 3.14f
    println(pi)
    pi = 3.1415926535f
    println(pi)
}

fun charCharacter() {
    val myChar:Char = '\\'
    println(myChar)

    val myCharacter = "Long Long Long"
    println(myCharacter.uppercase())
}

//studyReadInToInt
fun main() {
    var age = 0

    age = readlnOrNull()?.toIntOrNull() ?: run {
        println(age)
        return
    }

    var character = readlnOrNull() ?: ""
    println(character)
    println(age)
}