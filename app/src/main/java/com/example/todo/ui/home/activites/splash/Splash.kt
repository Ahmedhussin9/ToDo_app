package com.example.todo.ui.home.activites.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.example.todo.R
import com.example.todo.ui.home.activites.homeActivity.Home
import com.example.todo.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {
    lateinit var viewBinding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        navigateToHome()
    }
    fun navigateToHome(){
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        },2000)
    }

}