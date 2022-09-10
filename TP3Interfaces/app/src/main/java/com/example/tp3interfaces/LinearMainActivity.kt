package com.example.tp3interfaces

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp3interfaces.databinding.ActivityMainLinearBinding

class LinearMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainLinearBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLinearBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            startActivity(Intent(this, LinearAninhadoActivity::class.java))
        }
    }
}