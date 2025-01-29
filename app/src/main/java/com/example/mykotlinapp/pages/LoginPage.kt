package com.example.mykotlinapp.pages

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlinapp.HomeActivity
import com.example.mykotlinapp.R
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        auth = FirebaseAuth.getInstance()  // Initialize Firebase Auth

        val emailEditText: EditText = findViewById(R.id.editTextEmail)
        val passwordEditText: EditText = findViewById(R.id.editTextPassword)
        val loginButton: Button = findViewById(R.id.loginButton)
        val forgotPasswordLink: TextView = findViewById(R.id.forgotPasswordLink)

        // Login Button Action
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

         
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Authenticate user using Firebase
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign-in success
                            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                            // Redirect to the Home activity
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                            finish()  
                        } else {
                           
                            Toast.makeText(this, "Authentication Failed. Please check your credentials.", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

      
        forgotPasswordLink.setOnClickListener {
            val email = emailEditText.text.toString()

            if (email.isNotEmpty()) {
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Password reset email sent.", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Failed to send password reset email.", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Please enter your email to reset password.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
