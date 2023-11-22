package com.example.domian.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tasks")
data class Task(
    @ColumnInfo
    @PrimaryKey(true)
    var id:Int? = null,
    @ColumnInfo
    var title:String? = null,
    @ColumnInfo
    var description:String? = null,
    @ColumnInfo
    var dateTime:Long? = null,
    @ColumnInfo
    var isDone:Boolean = false
)
