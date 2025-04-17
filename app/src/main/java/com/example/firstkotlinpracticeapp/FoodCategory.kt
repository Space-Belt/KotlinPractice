package com.example.firstkotlinpracticeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodCategory(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String,
): Parcelable

//@SerializedName("categories")
data class FoodCategoriesResponse(
    val categories: List<FoodCategory>
)