package com.sps.android.domain.usecase

import com.sps.android.domain.model.TodoModel
import com.sps.android.domain.repository.TodoRepository

class AddNewTodoItemUseCase(private val repository: TodoRepository) {

    suspend fun addNewTodoItem(todoModel: TodoModel) {
        repository.addNewTodoItem(todoModel)
    }
}