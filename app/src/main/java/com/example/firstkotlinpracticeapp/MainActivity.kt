package com.example.firstkotlinpracticeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.example.firstkotlinpracticeapp.ui.theme.FirstKotlinPracticeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            FirstKotlinPracticeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    FoodRecipeApp(navController = navController)
                    Navigation()
                }
            }
        }
    }
}


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModel: LocationViewModel = viewModel()
    val context = LocalContext.current
    val locationUtils = LocationUtils(context)
    
    NavHost(navController, startDestination = "shoppinglistscreen") {
        composable("shoppinglistscreen") {
            ShoppingListApp(
                locationUtils = locationUtils,
                viewModel = viewModel,
                navController = navController,
                context = context,
                address = viewModel.address.value.firstOrNull()?.formatted_address ?: "주소 없음"
            )
        }
        dialog("locationscreen"){backstack ->
            viewModel.location.value?.let{it1 ->
                LocationSelectionScreen(location = it1, onLocationSelected = {locationdata ->
                    viewModel.fetchAddress("${locationdata.latitude},${locationdata.longitude}")
                    navController.popBackStack()
                })
            }
        }
    }


}


//@Serializable
//object Profile


//@Composable
//fun MyApp() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "firstNavigationScreen") {
//        composable("firstNavigationScreen"){
//            FirstScreen {name,age ->
//                val safeAge = age?.toString() ?: "null"
//                navController.navigate("SecondNavigationScreen/$name/$safeAge")
//            }
//        }
//        composable("secondNavigationScreen/{name}/{age}") {
//            val name = it.arguments?.getString("name") ?: "no Name"
//            val ageString = it.arguments?.getString("age")
//            val age = ageString?.toIntOrNull()
//            SecondScreen(
//                name,
//                age,
//                { navController.navigate("FirstNavigationScreen") },
//                { navController.navigate("ThirdNavigationScreen") }
//            )
//        }
//        composable("thirdNavigationScreen") {
//            ThirdScreen(
//                {navController.navigate("FirstNavigationScreen")},
//                {navController.navigate("SecondNavigationScreen") }
//            )
//        }
//
//    }
//}

//@Serializable
//object Profile
//@Serializable
//object FriendsList
//
//val navController = rememberNavController()
//
//NavHost(navController = navController, startDestination = Profile) {
//    composable<Profile> { ProfileScreen( /* ... */ ) }
//    composable<FriendsList> { FriendsListScreen( /* ... */ ) }
//    // Add more destinations similarly.
//}