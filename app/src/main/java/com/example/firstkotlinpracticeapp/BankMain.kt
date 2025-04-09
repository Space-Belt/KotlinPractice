package com.example.firstkotlinpracticeapp

fun main() {
    val wooBankAccount = BankAccount("woo", 1000.0)
    val booBankAccount = BankAccount("boo", 3000.0)
    val sooBankAccount = BankAccount("soo", 2000.0)


    wooBankAccount.deposit(200.0)
    wooBankAccount.withdraw(1200.0)
    wooBankAccount.deposit(3000.0)
    wooBankAccount.deposit(2000.0)
    wooBankAccount.withdraw(3333.15)
    wooBankAccount.displayTransactionHistory()

    sooBankAccount.deposit(100.0)
    sooBankAccount.withdraw(10.0)
    sooBankAccount.deposit(300.0)

    println("${wooBankAccount.accountHolder}의 잔액 $${wooBankAccount.acctBalance()}")
    println("${booBankAccount.accountHolder}의 잔액 $${booBankAccount.acctBalance()}")
    println("${sooBankAccount.accountHolder}의 잔액 $${sooBankAccount.acctBalance()}")

}