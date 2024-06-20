package com.sps.android.domain.repository

import com.sps.android.domain.model.TodoModel
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getTodoList(searchToken: String): Flow<List<TodoModel>>
    suspend fun addNewTodoItem(todoModel: TodoModel)
}