package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val findmenuitem = menuInflater
        findmenuitem.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.item1 -> {

                Intent(this, BmiActivity::class.java).also {
                    startActivity(it)
                }

            }

            R.id.item2 ->{Toast.makeText(this,"Already in simple cal. :)",Toast.LENGTH_SHORT).show()}
            }
        
        return super.onOptionsItemSelected(item)
    }
    var previousnumeric = false
    var decimal = false


    fun ondigit(view: View) {

        val input = (view as Button).text
        tvinput.append(input)
        previousnumeric = true
    }

    fun clear(view: View)
    {
        tvinput.text = " "
        previousnumeric = false
        decimal = false
    }

    fun decimal(view: View)
    {
        if(previousnumeric == true && decimal != true)
             tvinput.append(".")
        previousnumeric = false
        decimal = true

    }
    fun oprator(view: View)
    {
        if(previousnumeric == true &&  !checkoparetor(tvinput.text.toString()))
        {
            tvinput.append((view as Button).text)
            decimal = false
        }

    }

    fun equal(view: View) {



        if (previousnumeric) {

            var tvvalue = tvinput.text.toString()
            var prefix = ""

            try {
                if (tvvalue.startsWith("-"))
                {
                    prefix = "-"
                    tvvalue = tvvalue.substring(1)

                }




                if (tvvalue.contains("+")) {
                    val splitvalue = tvvalue.split("+")
                    var one = splitvalue[0]
                    var two = splitvalue[1]
                    if(!prefix.isEmpty())
                    {
                        one = prefix + one

                        Toast.makeText(this,"$one",Toast.LENGTH_SHORT).show()
                    }

                    tvinput.text = (one.toDouble() + two.toDouble()).toString()

                }
                else if (tvvalue.contains("-"))
                {       val splitvalue = tvvalue.split("-")
                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    if(!prefix.isEmpty())
                    {
                        one = prefix + one

                        Toast.makeText(this,"$one",Toast.LENGTH_SHORT).show()
                    }

                    tvinput.text = (one.toDouble() - two.toDouble()).toString()
                }
                else if(tvvalue.contains("*"))
                {
                    val splitvalue = tvvalue.split("*")
                    var one = splitvalue[0]
                    var two = splitvalue[1]


                    if(!prefix.isEmpty())
                    {
                        one = prefix + one

                        Toast.makeText(this,"$one",Toast.LENGTH_SHORT).show()
                    }

                    tvinput.text = (one.toDouble() * two.toDouble()).toString()
                }
                else if (tvvalue.contains("/"))
                {
                    val splitvalue = tvvalue.split("/")
                    var one = splitvalue[0]
                    var two = splitvalue[1]

                    if(!prefix.isEmpty())
                    {
                        one = prefix + one

                        Toast.makeText(this,"$one",Toast.LENGTH_SHORT).show()
                    }

                    tvinput.text = (one.toDouble() / two.toDouble()).toString()
                }
            }
            catch (e: ArithmeticException)
            {
                e.printStackTrace()
            }



        }
    }


    private fun checkoparetor(c : String): Boolean {
        return if(c.startsWith("-"))
                false
        else
         {
          c.contains("+") ||   c.contains("-") || c.contains("/") || c.contains("*")
         }

    }
}


