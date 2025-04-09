package com.example.firstkotlinpracticeapp

data class CoffeeDetails(
    val sugarCount:Int,
    val name:String,
    val size:String,
    val shotAmount: Int
)

fun main() {
    println("누구 커피?")

    val name = readlnOrNull()?.takeIf { it.isNotEmpty() } ?: "철수"
    println("설탕 몇 스푼?")
    val sugarCount = readlnOrNull().let {
        if (it.isNullOrEmpty()) {
            0
        } else {
            it.toIntOrNull() ?: 0
        }
    }
    println("사이즈 선택 기본 / 그란데 / 벤티")
    val size = readlnOrNull()?.takeIf { it.isNotEmpty() } ?: "기본"
    println("샷 개수 선택   기본 1")
    val shotCount = readlnOrNull().let {
        if (it.isNullOrEmpty()) {
            1
        } else {
            it.toIntOrNull() ?: 0
        }
    }
    val coffeeForMe = CoffeeDetails(sugarCount, name, size, shotCount)
    makeCoffee(coffeeForMe)
}

fun makeCoffee(coffeeDetails: CoffeeDetails) {
    when(coffeeDetails.sugarCount) {
        1 -> println("Coffee with ${coffeeDetails.sugarCount} spoon of sugar for ${coffeeDetails.name}")
        0 -> println("Coffee with no sugar for ${coffeeDetails.name}")
        else -> println("Coffee with ${coffeeDetails.sugarCount} spoons of sugar for ${coffeeDetails.name}")
    }
}