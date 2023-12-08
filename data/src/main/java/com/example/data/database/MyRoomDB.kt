package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase




@Database(entities = [com.example.domian.Model.Task::class], version = 1, exportSchema = true)

abstract class MyRoomDB:RoomDatabase() {
    abstract fun TasksDao():TasksDao
}