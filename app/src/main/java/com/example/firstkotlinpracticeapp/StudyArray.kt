package com.example.firstkotlinpracticeapp

fun main() {
    val numbers: IntArray = intArrayOf(1,2,3,4,5,6)
    // intArrayOf 이므로 타입은 추론됨
    val numbers2 = intArrayOf(1,2,3,4,5,6)
    val number3 = arrayOf(1,2,3,4,5,6)
    val numbersDoubleArray: DoubleArray = doubleArrayOf(1.0,2.0,3.0,4.0,5.0,6.0)

    // [I@4d41cee <- 주소로 저장된 위치
    println(numbers)
    // 유틸리티 메서드 사용해야함  [1, 2, 3, 4, 5, 6]
    println(numbers.contentToString())

    // 123456
    for(element in numbers) {
        print(element)
    }

    // 인덱스 접근
    print(numbers[0])

    numbers[0] = 9
    numbers[1] = 8
    numbers[2] = 7

    //  [9, 8, 7, 4, 5, 6]
    print("\n${numbers.contentToString()}")
    //  [1.0, 2.0, 3.0, 4.0, 5.0, 6.0]
    print("${numbersDoubleArray.contentToString()}")

    val fruits = arrayOf(Fruit("Apple", 2.5), Fruit("Grape", 3.5))
    //[Fruit(name=Apple, price=2.5), Fruit(name=Grape, price=3.5)]
    print(fruits.contentToString())

    for(fruit in fruits) {
        print(" ${fruit.name}")
    }

    print("dfsdfsdfdsf")
    val anything = arrayOf("1",2,Fruit("Apple", 2.5),5.0)
    print("\n ${anything}")

    // 인덱스알려주는 Indices
    for (index in fruits.indices) {
        print("${fruits[index].name} is in index ${index}")
    }

}

data class Fruit(val name:String, val price:Double)