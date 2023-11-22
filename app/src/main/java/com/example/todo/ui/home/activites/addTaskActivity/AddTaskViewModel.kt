package com.example.todo.ui.home.activites.addTaskActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.database.TasksDao
import com.example.todo.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val tasksDao:TasksDao,
):ViewModel (), AddTaskContract.ViewModel {
    var taskTitleLiveData = MutableLiveData<String>()
    var taskDescriptionLiveData = MutableLiveData<String>()
    var taskTimeLiveData = MutableLiveData<String>()
    var taskTitleError = MutableLiveData<String?>()
    var taskDescriptionError = MutableLiveData<String?>()
    var taskTimeError = MutableLiveData<String?>()
    var formIsValid= MutableLiveData<Boolean>()



    private val _state=MutableLiveData<AddTaskContract.State>()
    override val state=_state
    private val _event = SingleLiveEvent<AddTaskContract.Event>()
    override val event = _event

    override fun invokeAction(action: AddTaskContract.Action) {
        when (action){
            is AddTaskContract.Action.AddTask ->
                viewModelScope.launch(){
                   val task = com.example.domian.Model.Task(
                    title = taskTitleLiveData.value,
                    description = taskDescriptionLiveData.value,
                    dateTime = action.calender.timeInMillis
                )
                    tasksDao.insertTask(task)
            }
            is AddTaskContract.Action.PickDateAndTime ->showDateTimePicker()
            is AddTaskContract.Action.ValidateEditTexts ->validate()
        }
    }
     private fun validate() {
         var isValid = true
         if (taskTitleLiveData.value.isNullOrBlank()){
             taskTitleError.postValue("Please enter task name")
             isValid = false
         }else{
             taskTitleError.postValue(null)
         }
         if (taskDescriptionLiveData.value.isNullOrBlank()){
             isValid = false
             taskDescriptionError.postValue("Please enter description")

         }else{
             taskDescriptionError.postValue(null)
         }

         if (taskTimeLiveData.value.isNullOrBlank()){
             isValid = false
             taskTimeError.postValue("Please pick a time")

         }else{
             taskTimeError.postValue(null)
         }
        formIsValid.postValue(isValid)
    }
    private fun showDateTimePicker() {
       _event.postValue(AddTaskContract.Event.ShowDataTimePickerDialog())
    }
}