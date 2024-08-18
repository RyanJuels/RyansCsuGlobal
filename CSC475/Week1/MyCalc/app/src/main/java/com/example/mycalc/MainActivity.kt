package com.example.mycalc

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var resultTV : TextView
    lateinit var privTV : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultTV = findViewById(R.id.calcScreen)
        privTV = findViewById(R.id.privScreen)


    }

    override fun onClick(v: View?) {
        val eval = evaluate()
        val input = resultTV.text
        var result = ""
        if (input.length <= 35) {
            when (v?.id) {
                R.id.button0 -> {
                    result = "$input" + "0"
                }
                R.id.button1 -> {
                    result = "$input" + "1"
                }

                R.id.button2 -> {
                    result = "$input" + "2"
                }

                R.id.button3 -> {
                    result = "$input" + "3"
                }

                R.id.button4 -> {
                    result = "$input" + "4"
                }

                R.id.button5 -> {
                    result = "$input" + "5"
                }

                R.id.button6 -> {
                    result = "$input" + "6"
                }

                R.id.button7 -> {
                    result = "$input" + "7"
                }

                R.id.button8 -> {
                    result = "$input" + "8"
                }

                R.id.button9 -> {
                    result = "$input" + "9"
                }

                R.id.buttonP -> {
                    result = "$input + "
                }

                R.id.buttonM -> {
                    result = "$input - "
                }

                R.id.buttonD -> {
                    result = "$input / "
                }

                R.id.buttonX -> {
                    result = "$input * "
                }

                R.id.buttonRightP -> {
                    result = "$input ( "
                }

                R.id.buttonLeftP -> {
                    result = "$input ) "
                }
                R.id.buttonPeriod -> {
                    result = "$input."
                }
                R.id.buttonN -> {
                    result = "$input-"
                }
            }
            resultTV.text = result
        }

        if(v?.id == R.id.buttonE)
        {
            result = eval.evalEquals(input.toString())
            resultTV.text = result
            privTV.text = input
        }
        if(v?.id == R.id.buttonClear)
        {
            result = ""
            resultTV.text = result
            privTV.text = result
        }
    }
}