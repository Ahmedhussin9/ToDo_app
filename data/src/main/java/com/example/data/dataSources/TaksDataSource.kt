package com.example.data.dataSources

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.model.Task
import dagger.hilt.android.qualifiers.ApplicationContext

interface TasksDataSource {
 suspend  fun getTasksByDay(dateTime:Long,@ApplicationContext context: Context):List<com.example.domian.Model.Task>
}