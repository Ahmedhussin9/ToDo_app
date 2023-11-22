package com.example.data.repoImpl.taksRepositoryImpl

import android.content.Context
import com.example.data.dataSources.TasksDataSource
import com.example.domian.repository.loadtaskrepo.TasksRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TasksRepositoryImpl @Inject constructor(
    val dataSource: TasksDataSource
): TasksRepository {
    override suspend fun loadTasks(dateTime: Long, @ApplicationContext  context: Context):List<com.example.domian.Model.Task>  {
        return dataSource.getTasksByDay(dateTime,context)
    }
}