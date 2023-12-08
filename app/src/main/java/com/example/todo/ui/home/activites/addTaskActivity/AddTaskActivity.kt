package com.example.todo.ui.home.activites.addTaskActivity

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.todo.R
import com.example.todo.databinding.ActivityAddTaskBinding
import com.example.todo.ui.home.activites.homeActivity.Home
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class AddTaskActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityAddTaskBinding
    private lateinit var viewModel: AddTaskViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_task)
        viewModel = ViewModelProvider(this)[AddTaskViewModel::class.java]
        initViews()
        subscribeToLiveData()
        clickListeners()

    }
    private fun clickListeners() {
        viewBinding.addTaskButton.setOnClickListener(){
            viewModel.invokeAction(AddTaskContract.Action.ValidateEditTexts())
        }
        viewBinding.datePicker.setOnClickListener(){
            viewModel.invokeAction(AddTaskContract.Action.PickDateAndTime())
        }
        viewBinding.backButton.setOnClickListener(){
            finish()
        }
    }

    private fun subscribeToLiveData() {
        viewModel.event.observe(this){
            when(it){
                is AddTaskContract.Event.ShowDataTimePickerDialog ->showDatePickerDialog()
                else -> {}
            }
        }
        viewModel.formIsValid.observe(this){
            if (it==true){
                viewModel.invokeAction(AddTaskContract.Action.AddTask(calender.timeInMillis))

                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                finish()
            }
        }
        errorHandling()
    }
    private fun errorHandling() {
        viewModel.taskTitleError.observe(this){
            if (it !== null){
                viewBinding.titleContainer.error = it
            }else{
                viewBinding.titleContainer.error = null

            }
        }
        viewModel.taskDescriptionError.observe(this){
            if (it!=null){
                viewBinding.descriptionContainer.error = it
            }else{
                viewBinding.descriptionContainer.error = null
            }
        }
        viewModel.taskTimeError.observe(this){
            if (it!=null){
                viewBinding.dateContainer.error = it
            }else{
                viewBinding.dateContainer.error = null
            }
        }
    }
    val calender = Calendar.getInstance()
    private fun showDatePickerDialog() {
        val dialog  = DatePickerDialog(this)
        dialog.setOnDateSetListener{
                datePicker,year,month,day->

            viewBinding.datePicker.setText(
                "$day-${month+1}-$year"
            )
            calender.set(year,month,day)
            calender.set(Calendar.HOUR_OF_DAY,0)
            calender.set(Calendar.MINUTE,0)
            calender.set(Calendar.SECOND,0)
            calender.set(Calendar.MILLISECOND,0)
        }
        dialog.show()
    }
    private fun initViews() {
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
    }
}