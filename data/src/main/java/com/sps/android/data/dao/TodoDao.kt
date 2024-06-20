package com.sps.android.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sps.android.data.entities.TodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert
    suspend fun addNewTodoItem(todoEntity: TodoEntity)

    @Query("SELECT * From todo WHERE label LIKE :query")
    fun getTodoItems(query: String): Flow<List<TodoEntity>>
}