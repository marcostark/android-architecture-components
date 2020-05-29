package dev.marcosouza.roomtodo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
class Task(

    @PrimaryKey
    @ColumnInfo(name = "description")
    var description: String
)