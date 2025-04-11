package com.example.firstkotlinpracticeapp

fun main() {
    val numbers = listOf(1,2,3)
    val doubled = numbers.map{it * 2}
    println(doubled) // [2, 4, 6]

    val blueRoseVase = Vase(color = "Blue", design = "Rose")
    val redRoseVase = blueRoseVase.copy(color = "Red")
    println(blueRoseVase) //Vase(color=Blue, design=Rose)
    println(redRoseVase) //Vase(color=Red, design=Rose)

    // nullable String
    val name : String? = "Woo"
    name?.let{
        println(it.toUpperCase()) // WOO
    }

}

data class Vase(val color:String, val design: String)