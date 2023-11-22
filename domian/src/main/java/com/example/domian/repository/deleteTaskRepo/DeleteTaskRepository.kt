package com.example.domian.repository.deleteTaskRepo

import android.content.Context
import com.example.domian.Model.Task
import dagger.hilt.android.qualifiers.ApplicationContext


interface DeleteTaskRepository {
  suspend  fun deleteTask(task: Task)
}