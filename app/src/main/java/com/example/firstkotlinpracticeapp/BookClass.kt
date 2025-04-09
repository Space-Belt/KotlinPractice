package com.example.firstkotlinpracticeapp
import java.util.Calendar

class BookClass(val title: String = "살어리랏다", val author: String = "살어리", val yearPublished: Int = Calendar.getInstance().get(Calendar.YEAR)) {

}