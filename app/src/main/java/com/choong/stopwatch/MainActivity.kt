package com.choong.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.choong.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        setOnclickListener()
    }

    private fun setOnclickListener() {
        binding.btnStart.setOnClickListener {
            startStopwatch()
        }
        binding.btnStop.setOnClickListener {
            stopStopwatch()
        }
    }

    private fun startStopwatch() {

    }

    private fun stopStopwatch() {

    }

}