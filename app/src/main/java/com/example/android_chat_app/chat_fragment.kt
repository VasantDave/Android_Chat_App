package com.example.android_chat_app

import ChatDataAdapter
import ChatUserData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class chat_fragment : Fragment() {
    lateinit var chatRecycler : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var layout = inflater.inflate(R.layout.fragment_chat_fragment, container, false)

        chatRecycler = layout.findViewById(R.id.recyclerRecyclerView)
        chatRecycler.layoutManager = LinearLayoutManager(context)
        var chatList = listOf<ChatUserData>(
            ChatUserData(R.drawable.image1,"Profile 1","Sub Profile 1"),
            ChatUserData(R.drawable.image1,"Profile 2","Sub Profile 2"),
            ChatUserData(R.drawable.image1,"Profile 3","Sub Profile 3")
        )
        chatRecycler.adapter = ChatDataAdapter(chatList)
        return layout
    }
}