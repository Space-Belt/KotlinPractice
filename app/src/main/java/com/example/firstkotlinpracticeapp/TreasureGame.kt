package com.example.firstkotlinpracticeapp

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class TreasureGame {
    @Composable
    fun CaptainGame() {
        val directions = listOf("동", "서", "남", "북")
        val treasuresFound = remember { mutableStateOf(0) }
        val treasuresFounded by remember { mutableStateOf(0) }

        val direction = remember { mutableStateOf("북") }
        val toastMessage = remember { mutableStateOf("") }

        val stormOrTreasure = remember { mutableStateOf("") }

        val context = LocalContext.current

        fun showToast(dir: String) {
            direction.value = dir
            if(Random.nextBoolean()) {
                treasuresFound.value += 1
                toastMessage.value = ""
            } else {
                toastMessage.value = "못"
                stormOrTreasure.value = "폭풍이다!!"
            }
            Toast.makeText(context, "${direction.value}쪽에서 보물을 ${toastMessage.value}찾았습니다", Toast.LENGTH_SHORT).show()
        }

        @Composable
        fun DirectionButton(direction: String) {
            Button(
                onClick = {
                    showToast(direction)
                },

                ) {
                Text("${direction}쪽으로")
            }
        }

        @Composable
        fun DirectionButtons() { // 방향 리스트

            Row(modifier = Modifier.fillMaxWidth()) {
                directions.forEach { direction ->
                    DirectionButton(direction)  // 공통 버튼 컴포저블
                }
            }
        }

        Column(modifier = Modifier.padding(top = 50.dp)) {
            Text(text = "보물 발견: ${treasuresFound.value}")
            Text(text = "보물 방향: ${direction.value}")
            Row {
                Button(onClick = {
                    showToast("동")
                }){
                    Text("동쪽으로")
                }
                Button(onClick = {
                    showToast("서")
                }){
                    Text("서쪽으로")
                }
                Button(onClick = {
                    showToast("남")
                }){
                    Text("남쪽으로")
                }
                Button(onClick = {
                    showToast("북")
                }){
                    Text("북쪽으로")
                }
            }
            Row {
                DirectionButtons()

            }
            Text(text = stormOrTreasure.value)
        }
    }
}