package com.example.firstkotlinpracticeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FoodMainViewModel: ViewModel() {

    private val _categoriesState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categoriesState

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        // viewModel scope는 suspend 함수가 처리되도록 launch 제공해줌
        viewModelScope.launch{
            try {
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categories ?: emptyList(),

                    loading = false,
                    error = null
                )
            } catch(e: Exception) {
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "에러 발생: ${e.message}"
                )
            }
        }
    }

    data class RecipeState(
        val loading: Boolean = true,
        val list: List<FoodCategory> = emptyList(),
        val error: String? = null
    )

}