package com.example.firstkotlinpracticeapp

import com.example.firstkotlinpracticeapp.ui.theme.Tertiary

fun main() {
    val obj1 = InheritanceBaseClass()
    obj1.coreValues()

    val obj2 = InheritanceSecondClass()
    obj2.coreValues()
    obj2.role()

    val obj3 = Tertiary()
    obj3.role()
}