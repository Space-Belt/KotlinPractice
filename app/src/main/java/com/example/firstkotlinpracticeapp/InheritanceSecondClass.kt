package com.example.firstkotlinpracticeapp

class InheritanceSecondClass: InheritanceBaseClass() {
    override fun role() {
        super.role()
        println("베이스클래스 상속 후 오버라이드")
    }
}