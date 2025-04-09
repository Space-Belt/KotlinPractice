package com.example.firstkotlinpracticeapp

fun main() {
    // Imutable list
    val shoppingList = listOf("프로세서", "램", "그래픽카드", "SSD")
    // Mutable list
    val shoppingLists = mutableListOf("프로세서", "램", "그래픽카드3060", "SSD")
    // 추가  메소드
    shoppingLists.add("쿨러")
    // 삭제 메소드
    shoppingLists.remove("그래픽카드3060")
    shoppingLists.add("그래픽카드 4090")
    // [프로세서, 램, SSD, 쿨러, 그래픽카드 4090] 자바스크립트와 같이 없어지고 마지막에 추가됨
    println(shoppingLists)
}