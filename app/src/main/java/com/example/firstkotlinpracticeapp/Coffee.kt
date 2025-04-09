package com.example.firstkotlinpracticeapp

data class CoffeeDetails(
    val sugarCount:Int,
    val name:String,
    val size:String,
    val shotAmount: Int
)

class Coffee(val sugarCount: Int, val name: String, val size: String, val shotAmount: Int) {

    fun makeCoffee(coffeeDetails: CoffeeDetails) {
        if(coffeeDetails.sugarCount >= 0) {
            println("샷 ${coffeeDetails.sugarCount} 설탕 ${coffeeDetails.sugarCount} 사이즈 ${coffeeDetails.size} ${name}님꺼")
        }
    }
}


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

    makeCoffee(sugarCount,name)
}

fun makeCoffee(sugarCount: Int, name: String ) {
    when(sugarCount) {
        1 -> println("Coffee with $sugarCount spoon of sugar for $name")
        0 -> println("Coffee with no sugar for $name")
        else -> println("Coffee with $sugarCount spoons of sugar for $name")
    }
}