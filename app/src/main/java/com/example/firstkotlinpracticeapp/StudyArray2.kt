package com.example.firstkotlinpracticeapp

fun main() {
    val months = listOf("1월", "2월", "3월")
    val anyTypes = listOf(1,2,3,true,false,"문자열")

//    print(anyTypes.size) // 갯수
//    for (month in months) {
//        print(month) // 각 리스트
//    }

    val additionalMonths = months.toMutableList()
    val newMonths = arrayOf("4월", "5월", "6월")
    additionalMonths.addAll(newMonths)
    additionalMonths.add("7월")
    print(additionalMonths) // [1월, 2월, 3월, 4월, 5월, 6월, 7월]

    val days = mutableListOf<String>("월","잉?", "화", "수")
    days.add("목")
//    days[4] = "금" // 에러 발생 없는 인덱스에 할당 불가
//    days.removeAt(3) // 목요일 삭제됨
    val removeList = mutableListOf<String>("월","화")

//    days.removeAll(removeList) //월, 화 삭제
//    days.removeAll(days) // 전체삭제
    val replaceMap = mapOf(
        "월" to "바",
        "화" to "뀌",
        "수" to "어",
        "목" to "줘"
    )

    days.replaceAll { old -> replaceMap[old] ?: old }
    println("방법 1: $days") // [바, 잉?, 뀌, 어, 줘]

    val newDays = mutableListOf("바", "뀌", "어", "줘")
    days.forEachIndexed { index, _ ->
        if (index < newDays.size) days[index] = newDays[index]
    }
    println("방법 2: $days") // [바, 뀌, 어, 줘, 줘]

}