package com.example.firstkotlinpracticeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstkotlinpracticeapp.ui.theme.FirstKotlinPracticeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstKotlinPracticeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    RecipeScreen()
                    MyApp()
                }
            }
        }
    }
}

//@Serializable
//object Profile


@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstNavigationScreen") {
        composable("firstNavigationScreen"){
            FirstScreen {name,age ->
                val safeAge = age?.toString() ?: "null"
                navController.navigate("SecondNavigationScreen/$name/$safeAge")
            }
        }
        composable("secondNavigationScreen/{name}/{age}") {
            val name = it.arguments?.getString("name") ?: "no Name"
            val ageString = it.arguments?.getString("age")
            val age = ageString?.toIntOrNull()
            SecondScreen(
                name,
                age,
                { navController.navigate("FirstNavigationScreen") },
                { navController.navigate("ThirdNavigationScreen") }
            )
        }
        composable("thirdNavigationScreen") {
            ThirdScreen(
                {navController.navigate("FirstNavigationScreen")},
                {navController.navigate("SecondNavigationScreen") }
            )
        }

    }
}

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