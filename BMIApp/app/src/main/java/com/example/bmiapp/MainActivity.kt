package com.example.bmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val calculateButton = findViewById<Button>(R.id.calculate_button) as Button
        calculateButton.setOnClickListener {
            val weightId = findViewById<EditText>(R.id.weight_edit_text) as EditText
            val heightId = findViewById<EditText>(R.id.height_edit_view) as EditText
            if(weightId.text.isNotEmpty() && heightId.text.isNotEmpty()) {

                calculateBMI()
            }else{
                Toast.makeText(this,
                    "enter the needed field",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateBMI(){
        val weightId = findViewById<EditText>(R.id.weight_edit_text) as EditText
        val heightId = findViewById<EditText>(R.id.height_edit_view) as EditText
        val weight = weightId.text.toString().toFloat()

        val height = heightId.text.toString().toFloat()

        val myBMI = weight / (height * height)

        val bmiId = findViewById<TextView>(R.id.bmi_text_view) as TextView
        bmiId.text = myBMI.toString()

        val bmiImageId = findViewById<ImageView>(R.id.bmi_image_view) as ImageView

        if (myBMI < 18.5) {
            bmiImageId.setImageResource(R.drawable.underweight)
        } else if (myBMI >= 18.5 && myBMI < 24.9) {
            bmiImageId.setImageResource(R.drawable.healthy)
        } else if (myBMI >= 24.9 && myBMI < 29.9) {
            bmiImageId.setImageResource(R.drawable.overweight)
        } else if (myBMI >= 29.9) {
            bmiImageId.setImageResource(R.drawable.obesity)
        }
    }
}