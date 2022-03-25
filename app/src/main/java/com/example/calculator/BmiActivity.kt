 package com.example.calculator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bmi.*


class BmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)


       b6.setOnClickListener {
          cal()
       }


    }

    fun cal() {
        val h = edithight.text.toString()
        val w = editw.text.toString()

        if (!h.isEmpty() && !w.isEmpty()) {
            val BMI = (w.toDouble() / (h.toDouble() * h.toDouble()))


            //Round Double value

            val number3digit = Math.round(BMI * 1000.0) / 1000.0
            val number2digit = Math.round(number3digit * 100.0) / 100.0
            val finalBmi: Double = Math.round(number2digit * 10.0) / 10.0
            setbmi.text = finalBmi.toString()


            if (finalBmi < 18.5) {
                BMI0.text = "IN UNDER WEIGHT"
            } else if (finalBmi >= 18.5 && finalBmi <= 24.9) {

                BMI0.text = "Healthy"

            } else if (finalBmi >= 25.0 && finalBmi <= 29.9) {
                BMI0.text = "IN OVER WEIGHT"
            } else {
                BMI0.text = "obese"
            }
        }
        else
        {
            Toast.makeText(this,"enter valid value",Toast.LENGTH_SHORT).show()
        }
    }

    // create menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuin = menuInflater
        menuin.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    // menu option selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.item2 ->{

                Intent(this,MainActivity::class.java).also {
                    startActivity(it)
                }

            }
            R.id.item1 -> {
                Toast.makeText(this,"Already in BMI cal. :)", Toast.LENGTH_SHORT).show()}
        }
        return super.onOptionsItemSelected(item)
    }



}