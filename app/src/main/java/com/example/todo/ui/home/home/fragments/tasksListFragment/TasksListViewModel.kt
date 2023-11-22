package com.example.todo.ui.home.home.fragments.tasksListFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.database.TasksDao
import com.example.domian.Model.Task
import com.example.domian.usecases.deleteTask.DeleteTaskUseCase
import com.example.domian.usecases.loadTasks.LoadTasksByDayUseCase
import com.example.domian.usecases.markAsDone.MarkAsDoneUseCase
import com.example.todo.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class TasksListViewModel @Inject constructor(
    val loadTasksByDayUseCase: LoadTasksByDayUseCase,
    val deleteTaskUseCase: DeleteTaskUseCase,
    val markAsDoneUseCase: MarkAsDoneUseCase,
    val tasksDao: TasksDao
) :ViewModel(), TasksListContract.ViewModel {
    private val _state=MutableLiveData<TasksListContract.State>()
    override val state=_state
    private val _event = SingleLiveEvent<TasksListContract.Event>()
    override val event = _event
    var Tasks = MutableLiveData<List<Task>>()
    override fun invokeAction(action: TasksListContract.Action) {
        when(action){
            is TasksListContract.Action.LoadTasks ->loadTasks(action.dateTime)
            is TasksListContract.Action.DeleteTask -> deleteTask(action.task)
            is TasksListContract.Action.MarkTaskAsDone ->markTaskAsDone(action.task)
        }
    }
   private fun loadTasks(dateTime:Long) {
        viewModelScope.launch {
        val data = loadTasksByDayUseCase.invoke(loadTasksByDayUseCase.context,dateTime)
        Tasks.postValue(data)
        }
    }
    private fun markTaskAsDone(task: Task) {
        viewModelScope.launch {
            markAsDoneUseCase.invoke(task)
        }
    }
    private fun deleteTask(task: Task) {
        viewModelScope.launch {
            deleteTaskUseCase.invoke(task)
        }
    }
}