package com.example.todo.ui.home.home.fragments.tasksListFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domian.Model.Task
import com.example.todo.SingleLiveEvent

class TasksListContract {
    interface ViewModel{
        val state: MutableLiveData<State>
        val event: SingleLiveEvent<Event>
        fun invokeAction(action: Action)
    }
    sealed class Action(){
        class LoadTasks(val dateTime:Long): Action()
        class DeleteTask(val task: Task): Action()
        class MarkTaskAsDone(val task: Task): Action()
    }
    sealed class Event()
    sealed class State()
}