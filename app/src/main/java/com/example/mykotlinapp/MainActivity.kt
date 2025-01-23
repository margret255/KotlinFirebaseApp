package com.example.mykotlinapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlinapp.R.*
import com.example.mykotlinapp.R.id.*
import com.google.android.ads.mediationtestsuite.activities.HomeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var forgotPasswordText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.home)
        val buttonNavigateToSignUp:Button=findViewById(R.id.buttonNavigateToSignUp)

        //click listener
        buttonNavigateToSignUp.setOnClickListener{
            val intent = intent (this,signUp::class.java)
            startActivity(intent)
        }

        // Initialize UI components
        editTextName = findViewById(id.editTextName)
        editTextEmail = findViewById(id.editTextEmail)
        editTextPassword = findViewById(id.editTextPassword)
        loginButton = findViewById(id.loginButton)
        forgotPasswordText = findViewById(forgotPasswordLink)

        // the login button click listener
        loginButton.setOnClickListener {
            handleLogin()
        }

       
        forgotPasswordText.setOnClickListener {
           e)
            Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleLogin() {
        val name = editTextName.text.toString().trim()
        val email = editTextEmail.text.toString().trim()
        val password = editTextPassword.text.toString().trim()

   
        when {
            TextUtils.isEmpty(name) -> {
                editTextName.error = "Name is required"
                return
            }
            TextUtils.isEmpty(email) -> {
                editTextEmail.error = "Email is required"
                return
            }
            TextUtils.isEmpty(password) -> {
                editTextPassword.error = "Password is required"
                return
            }
        }

        
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

     
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
