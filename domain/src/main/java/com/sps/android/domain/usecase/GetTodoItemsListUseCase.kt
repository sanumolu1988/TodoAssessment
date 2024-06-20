package com.sps.android.domain.usecase

import com.sps.android.domain.model.TodoModel
import com.sps.android.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodoItemsListUseCase(private val todoRepository: TodoRepository) {

    fun getTodoList(searchToken: String): Flow<List<TodoModel>> {
        return todoRepository.getTodoList(searchToken)
    }
}