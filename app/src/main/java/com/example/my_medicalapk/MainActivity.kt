package com.example.my_medicalapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
// this is for login page
class MainActivity : AppCompatActivity() {
    lateinit var Txt_gotoregister: TextView
    lateinit var Edtloginemail: EditText
    lateinit var Edtloginpassword: EditText
    lateinit var Btn_Login: Button
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Txt_gotoregister=findViewById(R.id.Tvloginnextpage)
        Edtloginemail=findViewById(R.id.EdtloginEmail)
        Edtloginpassword =findViewById(R.id.EdtloginPassword)
        Btn_Login=findViewById(R.id.BtnLogin)
        auth= FirebaseAuth.getInstance()

        Txt_gotoregister.setOnClickListener{
            val intent= Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }
        Btn_Login.setOnClickListener{
            Loginpage()
            val users=Intent(this,UserActivity::class.java)
            startActivity(users)
        }
    }
    private fun Loginpage(){
        val email=Edtloginemail.toString()
        val password=Edtloginpassword.text.toString()
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this,"Successfully logged in", Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this,"Log in Failed", Toast.LENGTH_LONG).show()

            }

        }
    }
}
