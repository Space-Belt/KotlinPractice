package com.example.firstkotlinpracticeapp

fun main() {
    var computerChoice = ""
    var playerChoice = ""

    println("가위 바위 보!")
    println("가위 바위 보 중 하나를 입력하세요")
    playerChoice = readlnOrNull() ?: run {
        return
    }

    val randomNumber = (1..3).random()

    when (randomNumber) {
        1 -> {
            computerChoice = "가위"
        }
        2 -> {
            computerChoice = "바위"
        }
        3 -> {
            computerChoice = "보"
        }
    }
    val winner = when{
        playerChoice == computerChoice -> "비김!"
        playerChoice == "가위" && computerChoice == "바위" -> "플레이어"
        playerChoice == "보" && computerChoice == "바위" -> "플레이어"
        playerChoice == "가위" && computerChoice == "보" -> "플레이어"
        else -> "컴퓨터"
    }

    println("$winner")
}