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
    val navContoller = rememberNavController()
    NavHost(navController = navContoller, startDestination = "firstNavigationScreen") {
        composable("firstNavigationScreen"){
            FirstScreen {
                navContoller.navigate("SecondNavigationScreen")
            }
        }
        composable("secondNavigationScreen"){
            SecondScreen {
                navContoller.navigate("FirstNavigationScreen")
            }
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