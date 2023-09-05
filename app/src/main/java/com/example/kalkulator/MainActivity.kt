package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var firstNumber = ""
    var secondNumber = ""
    var selectedOperator = ""
    var result = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firstNumber = ""
        var secondNumber = ""
        var selectedOperator = ""
        var result = 0.0

    }

    fun inputNumber(view: View) {
        val number = (view as Button).text.toString()
        if (selectedOperator.isEmpty()) {
            firstNumber += number
            findViewById<TextView>(R.id.numberDisplay).text = firstNumber
        }  else {
            secondNumber += number
            findViewById<TextView>(R.id.numberDisplay).text = secondNumber
        }
    }

    fun inputOperator(view: View) {
        if (selectedOperator.isNotEmpty() && firstNumber.isNotEmpty() && secondNumber.isNotEmpty()) {
            calculate(view)
        }
        val operator = (view as Button).text.toString()
        selectedOperator = operator
        findViewById<TextView>(R.id.operator).text = operator
    }

    fun calculate(view: View) {
        if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty() && selectedOperator.isNotEmpty()) {
            val firstNum = firstNumber.toDouble()
            val secondNum = secondNumber.toDouble()

            result = when (selectedOperator) {
                "+" -> firstNum + secondNum
                "-" -> firstNum - secondNum
                "x" -> firstNum * secondNum
                "÷" -> firstNum / secondNum
                else -> 0.0
            }

            findViewById<TextView>(R.id.numberDisplay).text = result.toString()
            firstNumber = result.toString()
            secondNumber = ""
            selectedOperator = ""

            if (view.id == R.id.equalButton) {
                findViewById<TextView>(R.id.operator).text = ""
            } else {
                findViewById<TextView>(R.id.operator).text = (view as Button).text
            }
        }
    }

    fun reset(view: View) {
        firstNumber = ""
        secondNumber = ""
        selectedOperator = ""
        result = 0.0
        findViewById<TextView>(R.id.numberDisplay).text = ""
        findViewById<TextView>(R.id.operator).text = ""
    }
    fun inputDelete(view: View) {
        if (selectedOperator.isEmpty()) {
            // Hapus digit terakhir dari firstNumber
            if (firstNumber.isNotEmpty()) {
                firstNumber = firstNumber.substring(0, firstNumber.length - 1)
                findViewById<TextView>(R.id.numberDisplay).text = firstNumber
            }
        } else {
            // Hapus digit terakhir dari secondNumber
            if (secondNumber.isNotEmpty()) {
                secondNumber = secondNumber.substring(0, secondNumber.length - 1)
                findViewById<TextView>(R.id.numberDisplay).text = secondNumber
            }
        }
    }

}
