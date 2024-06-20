package com.sps.android.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class TodoEntity(@PrimaryKey(autoGenerate = true) val id: Int = 0, val label: String)