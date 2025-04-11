package com.example.firstkotlinpracticeapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModelMvvm : ViewModel() {
    private val _count = mutableStateOf(0)

    // _count 외부로 노출 시키기 위한 불변상태의 count
    val count : MutableState<Int> = _count

    fun increment() {
        _count.value++
    }

    fun decrement() {
        _count.value--
    }

}