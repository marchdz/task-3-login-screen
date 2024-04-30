package com.marchernandez.basicloginscreentask

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.marchernandez.basicloginscreentask.databinding.ActivityEmptyBinding

class EmptyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmptyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEmptyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}