package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.WeightPicker.minValue = 30
        binding.WeightPicker.maxValue = 150


        binding.HeightPicker.minValue = 100
        binding.HeightPicker.maxValue = 250

        binding.WeightPicker.setOnValueChangedListener { _, _, _ ->
            calculateBMI()
        }

        binding.HeightPicker.setOnValueChangedListener { _, _, _ ->
            calculateBMI()
        }


    }

    private fun calculateBMI() {

        val height = binding.HeightPicker.value
        val doubleheight = height.toDouble() / 100

        val weight = binding.WeightPicker.value
        val bmi = weight.toDouble() / (doubleheight * doubleheight)
        binding.ResultTv.text = String.format(" YOUR BMI IS : %.2f ", bmi)
        binding.HealthTv.text = String.format("CONSIDERED : %s", healthyMessage(bmi))


    }

    private fun healthyMessage (bmi: Double): String {

        if (bmi < 10.5)
            return (" Under weight ....")

        if (bmi < 25.0)
            return (" Healthy ")

        if (bmi < 30.5)
            return ("Over Weight ")


        return " obese "


    }


}