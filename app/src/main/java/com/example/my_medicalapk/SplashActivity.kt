package com.example.my_medicalapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager.LayoutParams as WindowManagerLayoutParams

class SplachActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManagerLayoutParams.FLAG_FULLSCREEN,
            WindowManagerLayoutParams.FLAG_FULLSCREEN
        )
        Handler(Looper.getMainLooper()).postDelayed({

            val intent=Intent( this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}