package com.example.conversoreurodolar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conversoreurodolar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonConversor.setOnClickListener {
            val euros : Double = binding.editEuro.text.toString().toDouble()
            val dollar : Double = euroToDollar(euros)

            binding.dollarResultado.text = String.format("USD %.2f", dollar)
        }
    }

    private fun euroToDollar(euros: Double) : Double {
        return euros * 0.91
    }

}