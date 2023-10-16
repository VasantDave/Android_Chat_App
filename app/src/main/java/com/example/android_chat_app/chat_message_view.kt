package com.example.android_chat_app

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class chat_message_view : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_message_view)
        var title: TextView = findViewById(R.id.title)
        var backbutton: ImageView = findViewById(R.id.backbutton)
        var chatMessage: FrameLayout = findViewById(R.id.chat_message_frame)
        title.text = intent.extras!!.getString("Title")
        supportFragmentManager.beginTransaction().replace(
            R.id.chat_message_frame, chat_message_ui_fragment()
        ).commit()
        backbutton.setOnClickListener {
            finish()
        }
//        supportFragmentManager.beginTransaction().show(
//            chat_message_ui_fragment()
//        ).commit()

    }
}