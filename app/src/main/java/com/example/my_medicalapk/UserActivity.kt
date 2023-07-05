package com.example.my_medicalapk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
// this is for user page
class UserActivity : AppCompatActivity() {
    lateinit var Edtusername: EditText
    lateinit var Edtuserage: EditText
    lateinit var Edtusergender: EditText
    lateinit var Edtuserheight: EditText
    lateinit var Edtuserweight: EditText
    lateinit var btn_done: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        Edtusername=findViewById(R.id.edtusername)
        Edtuserage =findViewById(R.id.edtuserage)
        Edtusergender=findViewById(R.id.edtusergender)
        Edtuserheight=findViewById(R.id.edtuserheight)
        Edtuserweight=findViewById(R.id.edtuserweight)
        btn_done=findViewById(R.id.Btn_done)

        btn_done.setOnClickListener{
            val intent= Intent(this,IntentActivity::class.java)
            startActivity(intent)
        }

        }
    }

