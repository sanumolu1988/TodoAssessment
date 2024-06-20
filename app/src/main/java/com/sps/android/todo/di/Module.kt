package com.sps.android.todo.di

import android.content.Context
import androidx.room.Room
import com.sps.android.data.dao.TodoDao
import com.sps.android.data.db.AppDatabase
import com.sps.android.data.repository.TodoRepositoryImpl
import com.sps.android.domain.repository.TodoRepository
import com.sps.android.domain.usecase.AddNewTodoItemUseCase
import com.sps.android.domain.usecase.GetTodoItemsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "todo_db").build()
    }

    @Provides
    fun provideTodoDao(db: AppDatabase): TodoDao {
        return db.todoDao()
    }

    @Provides
    fun provideTodoRepository(dao: TodoDao): TodoRepository {
        return TodoRepositoryImpl(dao)
    }

    @Provides
    fun provideGetTodoItemsListUseCase(repository: TodoRepository): GetTodoItemsListUseCase {
        return GetTodoItemsListUseCase(repository)
    }

    @Provides
    fun provideAddNewTodoItemUseCase(repository: TodoRepository): AddNewTodoItemUseCase {
        return AddNewTodoItemUseCase(repository)
    }
}
