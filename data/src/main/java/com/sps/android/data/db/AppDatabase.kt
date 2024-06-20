package com.sps.android.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sps.android.data.dao.TodoDao
import com.sps.android.data.entities.TodoEntity

@Database(entities = [TodoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}