package com.example.mykotlinapp.pages

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlinapp.R

class Homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // Fixed typo in 'savedInstanceState'
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home) // Links to the home.xml layout
    }
}

