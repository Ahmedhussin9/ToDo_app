package com.example.data.dataSourcesImpl.taksDSImpl

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.dataSources.TasksDataSource
import com.example.data.database.MyRoomDB
import com.example.domian.Model.Task
import javax.inject.Inject

class TasksDataSourceImpl @Inject constructor(
    val MyRoomDB:MyRoomDB
):TasksDataSource {
    override suspend fun getTasksByDay(
        dateTime: Long,
        context: Context
    ):List<Task> {
        return MyRoomDB.TasksDao().getTasksByDate(dateTime)
    }

}