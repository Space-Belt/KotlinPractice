package com.example.firstkotlinpracticeapp

fun main() {
    var computerChoice = ""
    var playerChoice = ""

//    println("가위 바위 보!")
//    println("가위 바위 보 중 하나를 입력하세요")
//    playerChoice = readlnOrNull() ?: ""

    while (true) {
        println("가위 바위 보!")
        println("가위 바위 보 중 하나를 입력하세요")
        playerChoice = readlnOrNull() ?: ""

        if (playerChoice == "가위" || playerChoice == "바위" || playerChoice == "보") {
            break  // 올바른 입력을 받으면 루프 종료
        } else {
            println("잘못 입력했습니다. 가위, 바위, 보 중에서 다시 입력해주세요.")
        }
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
    println("플레이어 $playerChoice")
    println("컴퓨터 $computerChoice")
    val winner = when{
        playerChoice == computerChoice -> "비김!"
        playerChoice == "가위" && computerChoice == "바위" -> "플레이어"
        playerChoice == "보" && computerChoice == "바위" -> "플레이어"
        playerChoice == "가위" && computerChoice == "보" -> "플레이어"
        else -> "컴퓨터"
    }

    if (winner == "비김!"){
        println(winner)
    } else {
        println("승자는 $winner 입니다.")
    }
}