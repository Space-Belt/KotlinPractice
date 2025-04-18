package com.example.firstkotlinpracticeapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(name: String, age: Int?, navigateToFirstScreen: (String) -> Unit, navigationToThirdScreen: () -> Unit) {


    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("두번째 화면 입니다.", fontSize = 24.sp)
        Text("환영 합니다. $name ${if (age !== null) "$age 세" else "나이 없음"}", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navigateToFirstScreen(name)
            }
        ) {
            Text("첫번째 화면 으로!")
        }
        Button(
            onClick = {
                navigationToThirdScreen()
            }
        ) {
            Text("세번째 화면 으로!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondPreview() {
//    SecondScreen("dfd",2,{},{})
}