package com.sps.android.data.repository

import com.sps.android.data.dao.TodoDao
import com.sps.android.data.entities.TodoEntity
import com.sps.android.domain.model.TodoModel
import com.sps.android.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoRepositoryImpl (private val todoDao: TodoDao) : TodoRepository {
     override fun getTodoList(seachToken:String): Flow<List<TodoModel>> {
        return todoDao.getTodoItems("%$seachToken%").map { it-> it.map { TodoModel(id =it.id, label = it.label) } }
    }

    override suspend fun addNewTodoItem(todoModel: TodoModel) {
        todoDao.addNewTodoItem(TodoEntity(label = todoModel.label))
    }

}