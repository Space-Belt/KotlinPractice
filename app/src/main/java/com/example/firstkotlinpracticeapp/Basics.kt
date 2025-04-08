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
fun studyReadInToInt() {
    var age = 0

    age = readlnOrNull()?.toIntOrNull() ?: run {
        println(age)
        return
    }

    var character = readlnOrNull() ?: ""
    println(character)
    println(age)
}

fun ageMain() {
    println("나이를 입력해주세요:")
    val age = readlnOrNull()?.toIntOrNull() ?: run {
        println("올바른 숫자를 입력해주세요")
        return
    }
    if (age in 18..40) {
        println("클럽입장허가")
    } else {
        println("입장 불가")
    }
}

fun main() {
    var userInput = readlnOrNull()
    while (userInput == "1") {
        println("반복중입니다.")
        userInput = readlnOrNull()
    }
    println("반복문 끝")

}
