package com.example.data.repoImpl.addTaskRepositoryImpl

import com.example.data.database.MyRoomDB
import com.example.domian.Model.Task
import com.example.domian.repository.addTaskRepo.AddTaskRepository
import javax.inject.Inject

class AddTaskRepoImpl @Inject constructor(
    val myRoomDB: MyRoomDB
):AddTaskRepository {
    override suspend fun AddTask(task: Task) {
        myRoomDB.TasksDao().insertTask(task)
    }
}