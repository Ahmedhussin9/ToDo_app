package com.example.domian.repository.markAsDone

import com.example.domian.Model.Task

interface MarkAsDoneRepository {
    suspend fun markAsDone(task:Task)
}