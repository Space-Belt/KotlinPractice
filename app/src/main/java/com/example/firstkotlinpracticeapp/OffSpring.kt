package com.example.firstkotlinpracticeapp

class OffSpring : InheritanceSecondClass(), Archer, Singer {
    override fun archer() {
        super.archer()
        println("자손의 향상된 궁수스킬")
    }
    override fun sing() {
        super.sing()
        println("자손의 향상된 노래스킬")
    }
}