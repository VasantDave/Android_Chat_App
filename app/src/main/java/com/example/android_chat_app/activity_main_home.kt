package com.example.android_chat_app

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.android_chat_app.databinding.ActivityMainHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class activity_main_home : AppCompatActivity() {

    lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)
        bottomNav = findViewById(R.id.chatBottom)
        changeFragment(chat_fragment())
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.chatView -> changeFragment(chat_fragment())
                R.id.profileView -> changeFragment(profile_fragment())
            }
            true
        }
    }

    private fun changeFragment(fragement: Fragment) {
        supportFragmentManager.beginTransaction().replace(
            R.id.frame_layout,fragement
        ).commit()
    }

//    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var binding: ActivityMainHomeBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainHomeBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        setSupportActionBar(binding.toolbar)
//
//        val navController = findNavController(R.id.nav_host_fragment_content_activity_main_home)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_activity_main_home)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}