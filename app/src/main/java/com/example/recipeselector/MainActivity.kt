package com.example.recipeselector

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var cuisineSpinner: Spinner
    private lateinit var showRecipeButton: Button
    private var selectedCuisine: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cuisineSpinner = findViewById(R.id.cuisine_spinner)
        showRecipeButton = findViewById(R.id.show_recipe_button)

        // Set up Spinner
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.cuisines_array,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        cuisineSpinner.adapter = adapter

        cuisineSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedCuisine = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }

        // Set up Button
        showRecipeButton.setOnClickListener {
            if (selectedCuisine != null) {
                Toast.makeText(this, "Showing recipe for $selectedCuisine", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please select a cuisine", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
