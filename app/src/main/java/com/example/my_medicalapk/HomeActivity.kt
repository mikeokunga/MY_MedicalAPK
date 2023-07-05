package com.example.my_medicalapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class HomeActivity : AppCompatActivity() {
    lateinit var Btnhomelogin: Button
    lateinit var Btnhomesignup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Btnhomelogin=findViewById(R.id.Btn_homelogin)
        Btnhomesignup=findViewById(R.id.Btn_homesignup)

        Btnhomelogin.setOnClickListener{
            val homelogin= Intent(this,MainActivity::class.java)
            startActivity(homelogin)
        }
        Btnhomesignup.setOnClickListener{
            val homesignup= Intent(this,RegistrationActivity::class.java)
            startActivity(homesignup)
        }
    }
}