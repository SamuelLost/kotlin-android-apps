package com.example.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOla.setOnClickListener {
            val nome : String = binding.editNome.text.toString()
//            binding.textResultado.text = "Olá, $nome"
//            binding.textResultado.text = "Olá, ${nome}"
            binding.textResultado.setText("Olá, ${nome}")
        }
    }
}