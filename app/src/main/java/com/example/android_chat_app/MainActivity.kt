package com.example.android_chat_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var signuptxt: TextView = findViewById(R.id.signupTxt)
        var loginButton: Button = findViewById(R.id.loginButton)

        signuptxt.setOnClickListener {
            intent = Intent(this, signupActivity::class.java)
            startActivity(intent)
        }
        loginButton.setOnClickListener {
            intent = Intent(this, activity_main_home::class.java)
            startActivity(intent)
//            intent = Intent(this, activity_main_home::class.java)
//            startActivity(intent)
        }

    }
}