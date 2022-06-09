package com.milano.deathclock

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.milano.deathclock.databinding.ActivityInfoBinding
import com.milano.deathclock.databinding.ActivityMainBinding

class InfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val outlooks = resources.getStringArray(R.array.outlooks)
        val arrayOutlooks = ArrayAdapter(this,R.layout.dropdown_item,outlooks)
        binding.autoCompleteTextView.setAdapter(arrayOutlooks)

        val drinkF = resources.getStringArray(R.array.drinking)
        val arrayDrink = ArrayAdapter(this,R.layout.dropdown_item,drinkF)
        binding.actvAlchohol.setAdapter(arrayDrink)

        val userName = findViewById<EditText>(R.id.etName)
        val userAge = findViewById<EditText>(R.id.etAge)
        val btnReturn = findViewById<Button>(R.id.btnReturn)


        btnReturn.setOnClickListener {

            val name = userName.text.toString()
            val age = userAge.text.toString()
            val gender = binding.etGender.text.toString()
            val outlook = binding.autoCompleteTextView.text.toString()
            val drink = binding.actvAlchohol.text.toString()

            val ms = (600000..315569520000).random()

            Intent(this, MainActivity::class.java).also {

                it.putExtra("EXTRA_MS",ms)
                it.putExtra("EXTRA_NAME", name)
                it.putExtra("EXTRA_AGE", age)
                it.putExtra("EXTRA_GENDER", gender)
                it.putExtra("EXTRA_OUTLOOK", outlook)
                it.putExtra("EXTRA_DRINK", drink)
                startActivity(it)
            }
        }
    }
}