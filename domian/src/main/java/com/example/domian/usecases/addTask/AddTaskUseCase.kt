package com.example.domian.usecases.addTask

import com.example.domian.Model.Task
import com.example.domian.repository.addTaskRepo.AddTaskRepository
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(
    var addTaskRepository: AddTaskRepository
) {
    suspend fun invoke(task:Task){
        addTaskRepository.AddTask(task)
    }
}