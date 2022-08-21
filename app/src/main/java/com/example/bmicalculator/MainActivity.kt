package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etHeight:EditText = findViewById(R.id.etHeight)
        val etWeight:EditText = findViewById(R.id.etWeight)

        val button:Button = findViewById(R.id.calculateButton)
        val bmiTextView: TextView = findViewById(R.id.tvYourBmiValue)
        val imageView:ImageView = findViewById(R.id.ivBmi)

        button.setOnClickListener {
            val bmi = calculateBMI(
                etHeight.text.toString().toDouble(),
                etWeight.text.toString().toDouble())

            bmiTextView.text=bmi.toString()

            if (bmi>24.9){
                imageView.setImageResource(R.drawable.ic_workout)
            }else{
                imageView.setImageResource(R.drawable.ic_eat)
            }
        }
    }
        private fun calculateBMI(height:Double, weight:Double):Double{

           return  weight/(height/100).pow(2)

    }
}