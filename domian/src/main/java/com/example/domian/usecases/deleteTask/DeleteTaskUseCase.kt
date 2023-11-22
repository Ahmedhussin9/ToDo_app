package com.example.domian.usecases.deleteTask

import com.example.domian.Model.Task
import com.example.domian.repository.deleteTaskRepo.DeleteTaskRepository
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    val deleteTaskRepository: DeleteTaskRepository
) {
    suspend fun invoke(task:Task){
        deleteTaskRepository.deleteTask(task)
    }
}