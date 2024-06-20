package com.sps.android.todo.presentation.todolist


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.sps.android.presentation.todo.TodoListViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.sps.android.data.repository.TodoRepositoryImpl
import com.sps.android.domain.model.TodoModel
import com.sps.android.domain.usecase.GetTodoItemsListUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreen(viewModel: TodoListViewModel, navController: NavController) {
    val todoList by viewModel.todoList.collectAsState(emptyList())
    val searchQuery by viewModel.searchToken.collectAsState()

    Scaffold(
        topBar = {
            TextField(
                value = searchQuery,
                onValueChange = { viewModel.updateSearchToken(it) },
                label = { Text("Search") },
                modifier = Modifier.fillMaxWidth()
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("details") }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { padding ->
        if (todoList.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Press the + button to add a TODO item")
            }
        } else {

            LazyColumn(modifier = Modifier.padding(padding)) {
                items(items = todoList, key = { todo -> todo.id ?: 0 }) { todo ->
                    TodoCard(todo, modifier = Modifier.padding(vertical = 1.dp))
                }
            }
        }
    }
}

@Composable
fun TodoCard(todo: TodoModel, modifier: Modifier) {
    Card(modifier = modifier) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.background(Color.White)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text(text = "" + todo.label, fontSize = 32.sp)
        }
    }
}


