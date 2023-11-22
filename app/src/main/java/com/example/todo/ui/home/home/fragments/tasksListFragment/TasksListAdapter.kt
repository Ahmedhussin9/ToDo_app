package com.example.todo.ui.home.home.fragments.tasksListFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.domian.Model.Task
import com.example.todo.databinding.DoneItemTaskBinding
import com.example.todo.databinding.ItemTaskBinding
import java.text.SimpleDateFormat
import java.util.Date

class TasksListAdapter(private var tasks:MutableList<Task>?):RecyclerView.Adapter<ViewHolder>() {

    class TaskViewHolder(var itemTaskBinding:ItemTaskBinding):RecyclerView.ViewHolder(itemTaskBinding.root){
        fun bind(task: Task){
                itemTaskBinding.title.text = task.title
                itemTaskBinding.dataTime.text = convertLongToTime(task)+" AM"
        }
        fun convertLongToTime(task: Task): String {
            val date = task.dateTime?.let { Date(it) }
            val format = SimpleDateFormat("HH:mm")
            return format.format(date)
        }
    }
    class DonetaskViewHolder(var itemTaskBinding:DoneItemTaskBinding):RecyclerView.ViewHolder(itemTaskBinding.root){
        fun bind(task: Task){
            itemTaskBinding.title.text = task.title
            itemTaskBinding.dataTime.text = convertLongToTime(task)+" AM"
        }
        fun convertLongToTime(task: Task): String {
            val date = task.dateTime?.let { Date(it) }
            val format = SimpleDateFormat("HH:mm")
            return format.format(date)
        }
    }
    override fun getItemViewType(position: Int): Int {
        if (tasks?.get(position)?.isDone==true){
            return TaskType.Done.value
        }else{
            return TaskType.notDone.value
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if(viewType == TaskType.Done.value){
            val itemTaskBinding = DoneItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return DonetaskViewHolder(itemTaskBinding)
        }else{
            val itemTaskBinding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return TaskViewHolder(itemTaskBinding)
        }
    }

    override fun getItemCount(): Int {
        return tasks?.size?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is TaskViewHolder){
            holder.bind(tasks!![position])
            holder.convertLongToTime(tasks!![position])
            if (onDeleteClickListner!=null){
                holder.itemTaskBinding.deleteView.setOnClickListener(){
                    holder.itemTaskBinding.swipeLayout.close(true)
                    onDeleteClickListner?.onDeleteClick(position,tasks!![position])
                }
            }
            if (onDoneClickListner!=null){
                holder.itemTaskBinding.done.setOnClickListener(){
                    onDoneClickListner?.onDoneClick(position,tasks!![position])
                }
            }

        }else if(holder is DonetaskViewHolder){
            holder.bind(tasks!![position])
            holder.convertLongToTime(tasks!![position])
            if (onDeleteClickListner!=null){
                holder.itemTaskBinding.deleteView.setOnClickListener(){
                    holder.itemTaskBinding.swipeLayout.close(true)
                    onDeleteClickListner?.onDeleteClick(position,tasks!![position])
                }
            }
        }
        }
    var onDoneClickListner: OnDoneClickListner?=null
    fun interface OnDoneClickListner{
        fun onDoneClick(position: Int,task:Task)
    }
    var onDeleteClickListner: OnDeleteClickListner?=null
    fun interface OnDeleteClickListner{
        fun onDeleteClick(position: Int,task:Task)
    }
    fun bindTasks(tasks: MutableList<Task>) {
        this.tasks = tasks
        notifyDataSetChanged()
    }
    fun taskDelete(task: Task) {
        val position = tasks?.indexOf(task)
        tasks?.remove(task)
        notifyItemRemoved(position!!)
    }

    fun markAsDone() {
        notifyDataSetChanged()
    }
}

enum class TaskType(val value:Int){
    Done(100),
    notDone(200)
}