package com.example.data.repoImpl.markAsDoneRepoImpl

import com.example.data.database.TasksDao
import com.example.domian.Model.Task
import com.example.domian.repository.markAsDone.MarkAsDoneRepository
import javax.inject.Inject

class MarkAsDoneRepositoryImpl @Inject constructor(
    val tasksDao: TasksDao
):MarkAsDoneRepository{
    override suspend fun markAsDone(task: Task) {
        tasksDao.updateTask(task)
        task.isDone = true
    }

}