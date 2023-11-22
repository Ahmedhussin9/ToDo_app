package com.example.todo.ui.home.activites.addTaskActivity

import androidx.lifecycle.MutableLiveData
import com.example.todo.SingleLiveEvent
import java.util.Calendar

class AddTaskContract {
    interface ViewModel{
        val state:MutableLiveData<State>
        val event:SingleLiveEvent<Event>
        fun invokeAction(action: Action)
    }
    sealed class Action{
        class AddTask(val calender:Calendar): Action()
        class ValidateEditTexts(): Action()
        class PickDateAndTime(): Action()
    }
    sealed class Event{
        class NavigateToTasksListFragment(): Event()
        class ShowDataTimePickerDialog(): Event()
    }
    sealed class State{

    }
}