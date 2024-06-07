package com.choong.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.choong.stopwatch.databinding.ActivityMainBinding
import java.util.Timer
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private var isRunning = false
    private var timer : Timer? = null
    private var time = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        setOnclickListener()
    }

    private fun setOnclickListener() {
        binding.btnStart.setOnClickListener {
            if (isRunning) {
                pauseStopwatch()
            }
            else {
                startStopwatch()
            }
        }
        binding.btnStop.setOnClickListener {
            refreshStopwatch()
        }
    }

    private fun startStopwatch() {
        binding.btnStart.text = "일시정지"
        isRunning = true

        timer = timer(period = 10) {
            time ++

            val millisecond = time%100
            val second = (time%6000)/100
            val minute = time/6000

            runOnUiThread {
                if (isRunning) {
                    binding.tvMillisecond.text =
                        if (millisecond < 10) ".0${millisecond}" else ".${millisecond}"
                    binding.tvSecond.text = if (second < 10) ":0${second}" else ":${second}"
                    binding.tvMin.text = "$minute"
                }
            }
        }

    }

    private fun pauseStopwatch() {

    }

    private fun refreshStopwatch() {

    }

}