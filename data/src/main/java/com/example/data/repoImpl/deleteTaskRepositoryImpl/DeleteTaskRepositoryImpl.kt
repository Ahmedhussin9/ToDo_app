package com.example.data.repoImpl.deleteTaskRepositoryImpl

import com.example.data.database.TasksDao
import com.example.domian.Model.Task
import com.example.domian.repository.deleteTaskRepo.DeleteTaskRepository
import javax.inject.Inject

class DeleteTaskRepositoryImpl @Inject constructor(
    val tasksDao: TasksDao
):DeleteTaskRepository {
    override suspend fun deleteTask(task: Task) {
        tasksDao.deleteTask(task)
    }
}