package com.example.firstkotlinpracticeapp

data class FoodCategory(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String,
)

//@SerializedName("categories")
data class FoodCategoriesResponse(
    val categories: List<FoodCategory>
)