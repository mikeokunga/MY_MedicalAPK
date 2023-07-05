package com.example.my_medicalapk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {
    lateinit var Txt_gotologin: TextView
    lateinit var Edtregemail: EditText
    lateinit var Edtregpassword: EditText
    lateinit var Edtconfirmpassword:EditText
    lateinit var Btn_Reg: Button
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registation)
        Txt_gotologin=findViewById(R.id.TvSignupnextpage)
        Edtregemail=findViewById(R.id.EdtsignupEmail)
        Edtregpassword =findViewById(R.id.EdtsignupPassword)
        Edtconfirmpassword =findViewById(R.id.EdtsignupconfirmPassword)
        Btn_Reg=findViewById(R.id.BtnRegister)
        auth= FirebaseAuth.getInstance()

        Txt_gotologin.setOnClickListener{
            val intent= Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }
        Btn_Reg.setOnClickListener{
            signuppage()
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
    private fun signuppage() {
        val email = Edtregemail.text.toString()
        val password = Edtregpassword.text.toString()
        val confpassword = Edtconfirmpassword.text.toString()

        if (email.isBlank() || password.isBlank() || confpassword.isBlank()) {
            Toast.makeText(this, "please password and email can't be blank", Toast.LENGTH_LONG)
                .show()
            return
        } else if (password != confpassword) {
            Toast.makeText(this, "Password do not match", Toast.LENGTH_LONG).show()
        }
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Signup is a success", Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this, "Failed, Please try again", Toast.LENGTH_LONG).show()
            }
        }
    }
}
