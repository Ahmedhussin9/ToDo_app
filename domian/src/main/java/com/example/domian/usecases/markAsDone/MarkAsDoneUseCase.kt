package com.example.domian.usecases.markAsDone

import com.example.domian.Model.Task
import com.example.domian.repository.markAsDone.MarkAsDoneRepository
import javax.inject.Inject

class MarkAsDoneUseCase @Inject constructor(
    val markAsDoneRepository: MarkAsDoneRepository
) {
    suspend fun invoke(task: Task){
        markAsDoneRepository.markAsDone(task)
    }
}