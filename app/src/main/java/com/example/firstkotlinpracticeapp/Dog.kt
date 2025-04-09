package com.example.firstkotlinpracticeapp

// 클래스 안에 어떤 종류의 변수를 원하는 지 적을 수 있다.
// 생성자 내에서 해당 항목들의 가시성을 명시적으로 수정하고 싶지 않으면 안해도됨
//class Dogg (name: String) {
//    init {
//        bark(name)
//    }
//    fun bark(name: string) {
//        println("$name 은 월월")
//    }
//}

// 이러면 매개변수가 아닌 프로퍼티가 된다.
// 매개변수는 그냥 객체에 정보를 전달한것이고,
// 프로퍼티가 되면 실제 객체의 일부가 된다.
// 따라서 매개변수로 전달 받으면 접근이 불가능 하고, 프로퍼티로 전달하면 접근이 가능하다.
// 이런 선언은 클래스 프로퍼티의 기본 값들도 포함될 수 있다.
// 즉 클래스의 객체가 생성될 때마다 이를 수정할 수 있는데,
// 특정 값이던 어떤 값이던 기본값이라는것이 있다. 즉 값을 특정해주거나 덮어씌우지 않아도 기본값존재
class Dog (val name: String, val breed: String, val age: Int = 0) {
    init {
        bark(name)
    }
    fun bark(name: String) {
        println("$name 은 월월")
    }
}
