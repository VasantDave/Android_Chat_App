package com.example.android_chat_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android_chat_app.databinding.ActivityMainBinding

class signupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        var loginText : TextView = findViewById(R.id.loginText)
        loginText.setOnClickListener {
            intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}