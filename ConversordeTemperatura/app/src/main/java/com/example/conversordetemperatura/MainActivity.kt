package com.example.conversordetemperatura

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conversordetemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoConverter.setOnClickListener {
            if(!binding.editTemp.text.isNullOrEmpty()) {
                val celcius = binding.editTemp.text.toString().toDouble()
                val fahrenheit = (celcius * 9 / 5) + 32
                binding.textResultado.text = "${fahrenheit}°F"
            } else {
                binding.textResultado.text = "Digite um valor"
            }

        }
    }
}