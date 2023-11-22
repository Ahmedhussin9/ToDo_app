package com.example.domian.usecases.loadTasks

import android.content.Context
import com.example.domian.Model.Task
import com.example.domian.repository.loadtaskrepo.TasksRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LoadTasksByDayUseCase @Inject constructor(
    val repository: TasksRepository,
     @ApplicationContext val context: Context
) {
    suspend fun invoke(@ApplicationContext context: Context, date:Long):List<Task>{
       return repository.loadTasks(date,context)
    }
}