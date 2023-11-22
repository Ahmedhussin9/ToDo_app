package com.example.domian.repository.loadtaskrepo

import android.content.Context
import com.example.domian.Model.Task
import dagger.hilt.android.qualifiers.ApplicationContext


interface TasksRepository {
  suspend  fun loadTasks(dateTime:Long,@ApplicationContext context: Context):List<Task>
}