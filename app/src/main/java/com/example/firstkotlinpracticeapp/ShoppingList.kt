package com.example.firstkotlinpracticeapp


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon


import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties

data class ShoppingItem(val id:Int,
                        var name: String,
                        var quantity:Int,
)

@Composable
fun ShoppingListApp() {
//    var shoppingItems by remember{ mutableStateOf(listOf<ShoppingItem>()) }
    val shoppingItems = remember { mutableStateListOf<ShoppingItem>() }
    var showDialog by remember { mutableStateOf(false) }

    var itemName by remember {mutableStateOf("")}
    var itemQuantity by remember {mutableStateOf("")}

    var activeItemEdit by remember {mutableStateOf("")}

    fun onEditClick(item: String, quantity: String, id: String) {
        itemName = item
        itemQuantity = quantity
        activeItemEdit = id
        showDialog = !showDialog
    }

    fun onDeleteClick(id: String) {
        val index = shoppingItems.indexOfFirst { it.id.toString() == id }
        shoppingItems.removeAt(index)
    }

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
            Text("사야할 것 추가")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            items(shoppingItems) {
                ShoppingListItem(it, ::onEditClick, ::onDeleteClick, {})
            }
        }
    }
    if(showDialog) {
        AlertDialog(
            properties = DialogProperties(usePlatformDefaultWidth = false),
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .wrapContentHeight(),
            containerColor = Color(0xFF87CEEB),
            onDismissRequest = { showDialog = !showDialog },
            confirmButton = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            if(activeItemEdit == "") {
                                val newItem = ShoppingItem(
                                    id = shoppingItems.size+1,
                                    name = itemName,
                                    quantity = itemQuantity.toInt(),
                                )
                                shoppingItems.add(newItem)
                            } else {
                                val index = shoppingItems.indexOfFirst { it.id.toString() == activeItemEdit }
                                if (index != -1) {
                                    shoppingItems[index] = shoppingItems[index].copy(
                                        name = itemName,
                                        quantity = itemQuantity.toIntOrNull() ?: 1
                                    )
                                }
                            }
                            activeItemEdit = ""
                            showDialog = !showDialog
                            itemName = ""
                            itemQuantity = ""
                        }
                    ) {
                        Text(
                            if (activeItemEdit !== "") "수정" else "추가"
                        )
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        label = { Text("물품") }
                        )
                    OutlinedTextField(
                        value = itemQuantity,
                        onValueChange = { itemQuantity = it },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        label = { Text("수량") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
            }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShoppingListItem(
    item: ShoppingItem,
    onEditClick: (item: String, quantity: String, id: String) -> Unit,
    onDeleteClick: (id: String) -> Unit,
    onSuccess: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color(0XFF018786)),
                shape = RoundedCornerShape(20)
            )
            .combinedClickable(  // 클릭 이벤트 결합
                onClick = {
                    onEditClick(item.name, item.quantity.toString(), item.id.toString())
                },
                onLongClick = { /* 롱클릭 처리 */ }
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column{
            Text(text = item.name, modifier = Modifier.padding(8.dp))
            Text(text = "수량 ${item.quantity}", modifier = Modifier.padding(8.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = { onDeleteClick(item.id.toString()) },
                ) {
                Text(
                    "완료/삭제",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 14.sp
                    )
                )
            }
        }

    }
}