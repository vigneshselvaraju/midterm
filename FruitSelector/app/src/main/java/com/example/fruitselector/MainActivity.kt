package com.example.fruitselector

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var fruitSpinner: Spinner
    private lateinit var fruitInfo: TextView
    private lateinit var addFruitButton: Button
    private lateinit var newFruitInput: EditText
    private lateinit var adapter: ArrayAdapter<String>
    private var fruitDescriptions = mapOf(
        "Apple" to "Apples are nutritious and good for health.",
        "Banana" to "Bananas are rich in potassium.",
        "Cherry" to "Cherries are small, round, and red.",
        "Date" to "Dates are sweet and come from date palms.",
        "Grape" to "Grapes can be eaten fresh or made into wine."
    )
    private val fruits = mutableListOf("Apple", "Banana", "Cherry", "Date", "Grape")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fruitSpinner = findViewById(R.id.fruitSpinner)
        fruitInfo = findViewById(R.id.fruitInfo)
        addFruitButton = findViewById(R.id.addFruitButton)
        newFruitInput = findViewById(R.id.newFruitInput)

        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, fruits)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        fruitSpinner.adapter = adapter

        fruitSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedFruit = parent.getItemAtPosition(position).toString()
                fruitInfo.text = fruitDescriptions[selectedFruit] ?: "No information available."
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                fruitInfo.text = "Select a fruit to see its info."
            }
        }

        addFruitButton.setOnClickListener {
            val newFruit = newFruitInput.text.toString()
            if (newFruit.isNotEmpty() && !fruits.contains(newFruit)) {
                fruits.add(newFruit)
                adapter.notifyDataSetChanged()
                newFruitInput.text.clear()
                fruitDescriptions += newFruit to "Description for $newFruit not available."
                Toast.makeText(this, "$newFruit added", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid or duplicate fruit", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
