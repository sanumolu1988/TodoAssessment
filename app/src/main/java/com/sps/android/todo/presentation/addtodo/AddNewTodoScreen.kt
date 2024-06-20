package com.sps.android.todo.presentation.addtodo

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.unit.dp
import com.sps.android.presentation.addtodo.AddNewTodoViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewTodoScreen(viewModel: AddNewTodoViewModel, navController: NavController) {
    var text by remember { mutableStateOf("") }
    var showValidationError by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter TODO item") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (text == "Error") {
                    showValidationError = true
                } else {
                    // Simulation
//                    for(i in 0..10){
//                        viewModel.addNewTodo(" Todo $i")
//                    }
                   viewModel.addNewTodo(text)
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add TODO")
        }
    }

    if (showValidationError) {
        AlertDialog(
            onDismissRequest = { showValidationError = false },
            title = { Text("Error") },
            text = { Text("Failed to add TODO") },
            confirmButton = {
                Button(onClick = {
                    showValidationError = false
                    navController.popBackStack()
                }) {
                    Text("OK")
                }
            }
        )
    }
}



