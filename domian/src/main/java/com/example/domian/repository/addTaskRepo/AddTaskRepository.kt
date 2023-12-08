package com.example.domian.repository.addTaskRepo

import com.example.domian.Model.Task

interface AddTaskRepository {
    suspend fun AddTask(task: Task)
}