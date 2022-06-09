package com.milano.deathclock

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.milano.deathclock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val tvSeconds = findViewById<TextView>(R.id.tvSeconds)
        val tvMinutes = findViewById<TextView>(R.id.tvMinutes)
        val tvHours = findViewById<TextView>(R.id.tvHours)
        val tvDays = findViewById<TextView>(R.id.tvDays)
        val tvMonths = findViewById<TextView>(R.id.tvMonths)
        val tvYears = findViewById<TextView>(R.id.tvYears)
        val btnExtend = findViewById<Button>(R.id.btnExtend)
        val btnWWID = findViewById<Button>(R.id.btnWWID)

        val name = intent.getStringExtra("EXTRA_NAME")
        val age = intent.getStringExtra("EXTRA_AGE")
        val gender = intent.getStringExtra("EXTRA_GENDER")
        val outlook = intent.getStringExtra("EXTRA_OUTLOOK")
        val drink = intent.getStringExtra("EXTRA_DRINK")

        val millieSeconds = intent.getIntExtra("EXTRA_MS", 0)

        tvName.text = name
        if (tvName.text.toString().isEmpty()) {
            tvName.text = "Your Name"
        }

        tvAge.text = "Age: " + age
        if (tvAge.text.toString().isEmpty()) {
            tvAge.text = "Your Age"
        }

        binding.tvGender.text = gender
        binding.tvOutlook.text = "Your Outlook on life is " + outlook
        binding.tvDrink.text = "Your drinking frequency is " + drink

        object : CountDownTimer(millieSeconds.toLong(), 1000) {

            override fun onTick(millisUntilFinished: Long) {

                val secondsRemaining = millisUntilFinished / 1000
                val minuteRemaining = secondsRemaining / 60
                val hoursRemaining = minuteRemaining / 60
                val daysRemaining = hoursRemaining / 24
                val monthsRemaining = daysRemaining / 30
                val yearsRemaining = monthsRemaining / 12

                tvSeconds.text = ("Seconds: " + secondsRemaining)
                tvMinutes.text = ("Minutes: " + minuteRemaining)
                tvHours.text = ("Hours: " + hoursRemaining)
                tvDays.text = ("Days: " + daysRemaining)
                tvMonths.text = ("Months: " + monthsRemaining)
                tvYears.text = ("Years: " + yearsRemaining)

            }

            override fun onFinish() {
                tvSeconds.text = "Seconds: 0"
                tvMinutes.text = "Minutes: 0"
                tvHours.text = "Hours: 0"
                tvDays.text = "Days: 0"
                tvMonths.text = "Months: 0"
                tvYears.text = "Years: 0"
            }
        }.start()

        btnExtend.setOnClickListener {
            Intent(this, InfoActivity::class.java).also {
                startActivity(it)
                //finish()
            }
        }
    }
}