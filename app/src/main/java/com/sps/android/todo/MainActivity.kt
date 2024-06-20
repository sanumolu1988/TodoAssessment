package com.sps.android.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sps.android.todo.presentation.addtodo.AddNewTodoScreen
import com.sps.android.todo.presentation.todolist.TodoListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "todolist") {
                composable("todolist") {
                    TodoListScreen(
                        viewModel = hiltViewModel(),
                        navController
                    )
                }
                composable("details") {
                    AddNewTodoScreen(
                        viewModel = hiltViewModel(),
                        navController
                    )
                }
            }
        }
    }
}
