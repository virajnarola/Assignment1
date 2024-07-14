package com.example.assignment1

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var foodSpinner: Spinner
    private lateinit var addButton: Button
    private lateinit var orderButton: Button
    private lateinit var selectedFoodListView: ListView
    private lateinit var selectedFoodList: ArrayList<String>
    private lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foodSpinner = findViewById(R.id.foodSpinner)
        addButton = findViewById(R.id.addButton)
        orderButton = findViewById(R.id.orderButton)
        selectedFoodListView = findViewById(R.id.selectedFoodListView)
        selectedFoodList = ArrayList()
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, selectedFoodList)
        selectedFoodListView.adapter = arrayAdapter

        // Spinner Adapter
        val foodItems = arrayOf("Pizza", "Burger", "Pasta", "Salad")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, foodItems)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        foodSpinner.adapter = spinnerAdapter

        addButton.setOnClickListener {
            val selectedFood = foodSpinner.selectedItem.toString()
            selectedFoodList.add(selectedFood)
            arrayAdapter.notifyDataSetChanged()
        }

        orderButton.setOnClickListener {
            val orderSummary = selectedFoodList.joinToString(", ")
            Toast.makeText(this, "Order placed: $orderSummary", Toast.LENGTH_LONG).show()
            selectedFoodList.clear()
            arrayAdapter.notifyDataSetChanged()
        }
    }
}
