package com.example.firstkotlinpracticeapp

class BankAccount(
    var accountHolder: String,
    var balance: Double
) {
    // 거래내역 담을 변수 / 값없이 타입 정의해서 리스트 추가
    // private 선언으로 클래스 외부에서 접근 불가 / 클래스 내부 함수에서만 접근이 가능함
    private val transactionHistory = mutableListOf<String>()

    // 입금
    fun deposit(amount: Double) {
        balance += amount
        transactionHistory.add("$accountHolder 입금 $$amount")
    }

    // 출금
    fun withdraw(amount: Double) {
        if(amount <= balance) {
            balance -= amount
            transactionHistory.add("$accountHolder 출금 $$amount")
        } else {
            println("$$amount 출금 불가")
        }
    }

    fun acctBalance():Double {
        return balance
    }

    // 거래내역확인
    fun displayTransactionHistory() {
        println("${accountHolder}의 입출금 내역")
        for(transaction in transactionHistory) {
            println(transaction)
        }
    }

}