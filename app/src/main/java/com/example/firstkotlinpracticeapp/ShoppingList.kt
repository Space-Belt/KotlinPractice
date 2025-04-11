package com.example.firstkotlinpracticeapp


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

data class ShoppingItem(val id:Int,
                        var name: String,
                        var quantity:Int,
                        var isEditing: Boolean = false
)

@Composable
fun ShoppingListApp() {
    var shoppingItems by remember{ mutableStateOf(listOf<ShoppingItem>()) }
    var showDialog by remember { mutableStateOf(false) }

    var itemName by remember {mutableStateOf("")}
    var itemQuantity by remember {mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                showDialog = !showDialog
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("쇼핑 물건 추가")
        }
    }
    if(showDialog) {
        AlertDialog(
            containerColor = Color(0xFF87CEEB),
            onDismissRequest = { showDialog = !showDialog },
            confirmButton = {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {

                        }
                    ) {
                        Text("추가")
                    }
                    Button(
                        onClick = {

                        }
                    ) {
                        Text("취소")
                    }
                }
            },
            title = {(Text("안녕하세요"))},
            text = {
                Column {
                    OutlinedTextField(
                        value = itemName,
                        onValueChange = { itemName = it },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                        label = { Text("상품명") }
                        )
                    OutlinedTextField(
                        value = itemQuantity,
                        onValueChange = { itemQuantity = it },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                        label = { Text("수량") }
                    )
                }
            }
        )
    }
}