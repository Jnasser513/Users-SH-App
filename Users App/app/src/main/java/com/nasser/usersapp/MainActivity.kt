package com.nasser.usersapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nasser.usersapp.classes.User
import com.nasser.usersapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(mutableListOf())
        linearLayoutManager = LinearLayoutManager(this)

        binding.usersRecyclerview.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }
}