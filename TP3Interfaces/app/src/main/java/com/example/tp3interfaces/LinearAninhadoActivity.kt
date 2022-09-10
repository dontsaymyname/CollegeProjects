package com.example.tp3interfaces

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.tp3interfaces.databinding.ActivityLinearAninhadoBinding

class LinearAninhadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLinearAninhadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLinearAninhadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val colorsList = listOf(
            R.color.yellow,
            R.color.gray,
            R.color.green,
            R.color.blue,
            R.color.pink,
            R.color.red,
            R.color.black,
        )

        binding.run {
            btnTopleft.setOnClickListener {
                btnTopright.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        this@LinearAninhadoActivity,
                        colorsList.random()
                    )
                )
            }
            btnTopright.setOnClickListener {
                btnBottomright.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        this@LinearAninhadoActivity,
                        colorsList.random()
                    )
                )
            }
            btnBottomleft.setOnClickListener {
                btnTopleft.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        this@LinearAninhadoActivity,
                        colorsList.random()
                    )
                )
            }
            btnBottomright.setOnClickListener {
                btnBottomleft.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        this@LinearAninhadoActivity,
                        colorsList.random()
                    )
                )
            }

            btnNext.setOnClickListener {
                startActivity(Intent(this@LinearAninhadoActivity, ConstraintLayoutActivity::class.java))
            }
        }


    }

}