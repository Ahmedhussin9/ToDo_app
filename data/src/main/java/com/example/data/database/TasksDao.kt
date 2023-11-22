package com.example.data.database


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.data.model.Task

@Dao
interface TasksDao {
    @Insert
    suspend fun insertTask(task: com.example.domian.Model.Task)
     @Update
    suspend fun updateTask(task: com.example.domian.Model.Task)
    @Delete
     suspend fun deleteTask(task: com.example.domian.Model.Task)
    @Query("select * from tasks")
   suspend fun getAllTasks():List<Task>

    @Query("select * from tasks where dateTime = :dateTime")
   suspend  fun getTasksByDate(dateTime:Long): List<com.example.domian.Model.Task>
}