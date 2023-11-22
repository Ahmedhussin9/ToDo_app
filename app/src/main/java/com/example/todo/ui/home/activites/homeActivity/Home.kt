package com.example.todo.ui.home.activites.homeActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.todo.R
import com.example.todo.databinding.ActivityHomeBinding
import com.example.todo.ui.home.activites.addTaskActivity.AddTaskActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : AppCompatActivity() {
    lateinit var viewBinding:ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val navController = findNavController(R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(viewBinding.bottomNavView,navController)
        viewBinding.fab.setOnClickListener(){
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
    }


}