package com.example.firstkotlinpracticeapp

/* 루프 다루기 */
fun main() {
    val shoppingList = mutableListOf("프로세서", "램", "그래픽카드3060", "SSD")

    // for in / break / lastIndex
    for(item in shoppingList) {
        println(item)
        if(item == "램") {
            shoppingList.removeAt(shoppingList.lastIndex)
            break
        }
    }

    // [.size 아이템 갯수]
    // item 이 Index값임  shoppingList[item] 으로 활용 가능
    // until 은 시작숫자 <= 동안 < 마지막숫자 임
    for(index in 0 until shoppingList.size) {
        println(index) // 0 1 2 3
    }

    for(index in 0..3) {
        println(index)
    }

    println(shoppingList)

}



/* 리스트 다루기
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

    // [프로세서, 램, 쿨러, 그래픽카드 4090] 해당 인덱스 삭제
    shoppingLists.removeAt(2)
    println(shoppingLists)

    shoppingLists.add(2,"램")
    println(shoppingLists[2])

    // 해당 인덱스 대체
    shoppingLists[3] = "그래픽카드"
    println(shoppingLists[3])

    // set은 이제 잘 사용 하지 않는것 같음 위에것 사용 (버전마다 다름)
    shoppingLists.set(1, "물쿨링")
    println(shoppingLists[1])

    // contains 포함하는지 확인
    val hasRam = shoppingLists.contains("램")
    if(hasRam){
        println("램 있음")
    } else {
        println("램 없음")
    }
}
*/