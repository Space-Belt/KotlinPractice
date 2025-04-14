package com.example.firstkotlinpracticeapp

fun main() {
    val obj1 = InheritanceBaseClass()
    obj1.coreValues()

    val obj2 = InheritanceSecondClass()
    obj2.coreValues()
    obj2.role()

    val obj3 = Tertiary()
    obj3.role()

    val interfaceObj4 = OffSpring()
    interfaceObj4.archer()
    interfaceObj4.role()
    interfaceObj4.coreValues()
    interfaceObj4.sing()

}

class Tertiary : InheritanceBaseClass() {
    override fun role() {
//        println('새로운 역할 부여')
    }
}