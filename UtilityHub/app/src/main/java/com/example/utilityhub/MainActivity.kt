package com.example.utilityhub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculatorButton = findViewById<Button>(R.id.calculatorButton)
        val fruitSelectorButton = findViewById<Button>(R.id.fruitSelectorButton)

        calculatorButton.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", "Launching Calculator")
            startActivity(intent)
        }

        fruitSelectorButton.setOnClickListener {
            val intent = Intent(this, FruitSelectorActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", "Launching Fruit Selector")
            startActivity(intent)
        }
    }
}
