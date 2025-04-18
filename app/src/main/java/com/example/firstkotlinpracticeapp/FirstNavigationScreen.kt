package com.example.firstkotlinpracticeapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(navigationToSecondScreen: (String, Int?) -> Unit) {

    val name = remember {
        mutableStateOf("")
    }

    val age = remember {
        mutableStateOf<Int?>(null)
    }

    val ageText = remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("첫번째 화면입니다.", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = name.value, onValueChange = {
            name.value = it
        })

        OutlinedTextField(value = ageText.value, onValueChange = {
            newText -> ageText.value = newText
            age.value = newText.toIntOrNull()
        },
            label = { Text("나이") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
        )

        Button(
            onClick = {
                navigationToSecondScreen(name.value, age.value)
            }
        ) {
            Text("두번쨰 화면 텍스트 보내기!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstPreview() {
//    FirstScreen({})
}