package com.example.firstkotlinpracticeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable

@Composable
fun FoodRecipeApp(navController: NavHostController) {
    val recipeViewModel: FoodMainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(
        navController = navController,
        startDestination = FoodSealedScreen.RecipeScreen.route
    ) {
        composable(
            route = FoodSealedScreen.RecipeScreen.route
        ){
            RecipeScreen(
                viewState = viewState,
                navigateToDetail = {
                    // 현재화면에서 상세화면으로 가는것 추가
                    navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                    navController.navigate(FoodSealedScreen.DetailScreen.route)
                }
            )
        }
        composable(
            route = FoodSealedScreen.DetailScreen.route
        ) {
            val category = navController.previousBackStackEntry?.
            savedStateHandle?.get<FoodCategory>("cat")
                ?: FoodCategory("","", "", "")
            FoodDetailScreen(
                category = category
            )
        }
    }
}