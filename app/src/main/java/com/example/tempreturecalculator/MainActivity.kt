package com.example.tempreturecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button2)
        val input : EditText = findViewById((R.id.input))
        val result : TextView = findViewById(R.id.textView5)

        var flag: String = "Fahrenheit"

        val spinnerVal : Spinner = findViewById(R.id.spinner1)
        var options = arrayOf("Fahrenheit","Kelvin")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        button.setOnClickListener{view->
            if(input.text.toString() != "") {
                var num: Double = input.text.toString().toDouble()
                var res: Double

                if (flag == "Fahrenheit") {
                    res = (num - 32) * 5 / 9
                } else {
                    res = num - 273.15
                }
                result.text = res.toString()
            }
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
}
}