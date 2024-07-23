package com.example.utilityhub

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val message = intent.getStringExtra("EXTRA_MESSAGE")
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)
        val result = findViewById<TextView>(R.id.result)

        addButton.setOnClickListener {
            performOperation(number1, number2, "Addition", result)
        }

        subtractButton.setOnClickListener {
            performOperation(number1, number2, "Subtraction", result)
        }

        multiplyButton.setOnClickListener {
            performOperation(number1, number2, "Multiplication", result)
        }

        divideButton.setOnClickListener {
            performOperation(number1, number2, "Division", result)
        }
    }

    private fun performOperation(number1: EditText, number2: EditText, operation: String, result: TextView) {
        val num1 = number1.text.toString().toDoubleOrNull()
        val num2 = number2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val res = when (operation) {
            "Addition" -> num1 + num2
            "Subtraction" -> num1 - num2
            "Multiplication" -> num1 * num2
            "Division" -> {
                if (num2 != 0.0) num1 / num2 else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
            }
            else -> 0.0
        }

        result.text = "Result: $res"
    }
}
