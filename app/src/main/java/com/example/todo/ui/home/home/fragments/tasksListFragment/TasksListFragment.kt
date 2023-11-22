package com.example.todo.ui.home.home.fragments.tasksListFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.todo.databinding.FragmentTasksListBinding
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Calendar

@AndroidEntryPoint
class TasksListFragment : Fragment() {
    lateinit var viewBinding:FragmentTasksListBinding
     lateinit var viewModel: TasksListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[TasksListViewModel::class.java]

    }

    private fun subscribeToLiveData() {

        viewModel.Tasks.observe(viewLifecycleOwner){
            tasksAdapter.bindTasks(it.toMutableList()) }
    }

    private fun loadTasks() {
        viewModel.invokeAction(TasksListContract.Action.LoadTasks(selectedDate.timeInMillis))

    }

    val tasksAdapter= TasksListAdapter(null)

    private fun initViews() {
        viewBinding.recyclerView.adapter =tasksAdapter
        viewBinding.calendarView.setOnDateChangedListener(OnDateSelectedListener{
                widget, date, selected ->
            if (selected){
                selectedDate.set(Calendar.YEAR,date.year)
                selectedDate.set(Calendar.MONTH,date.month-1)
                selectedDate.set(Calendar.DAY_OF_MONTH,date.day)
                viewModel.invokeAction(TasksListContract.Action.LoadTasks(selectedDate.timeInMillis))
            }
        })
        tasksAdapter.onDeleteClickListner= TasksListAdapter.OnDeleteClickListner{
                position, task ->
            viewModel.invokeAction(TasksListContract.Action.DeleteTask(task))
            tasksAdapter.taskDelete(task)
        }
        tasksAdapter.onDoneClickListner = TasksListAdapter.OnDoneClickListner{
            position, task ->
            viewModel.invokeAction(TasksListContract.Action.MarkTaskAsDone(task))
            tasksAdapter.markAsDone()
        }
    }

    private val selectedDate: Calendar = Calendar.getInstance()
     private fun initCalander() {
            selectedDate.set(Calendar.HOUR,0)
            selectedDate.set(Calendar.SECOND,0)
            selectedDate.set(Calendar.MINUTE,0)
            selectedDate.set(Calendar.MILLISECOND,0)
        viewBinding.calendarView.selectedDate = CalendarDay.today()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewBinding = FragmentTasksListBinding.inflate(inflater,container,false)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCalander()
        initViews()
        loadTasks()
        subscribeToLiveData()

    }
}