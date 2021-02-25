package com.example.HW1_HannahJuarez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        var isFruit = false
        val spinner: Spinner = findViewById(R.id.favorite_spinner)
        val fruitAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.fruit_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        val flowerAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.flower_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        findViewById<RadioButton>(R.id.favorite_fruit_radio).setOnClickListener {
            spinner.adapter = fruitAdapter
            isFruit = true
        }
        findViewById<RadioButton>(R.id.favorite_flower_radio).setOnClickListener {
            spinner.adapter = flowerAdapter
            isFruit = false
        }
        findViewById<Button>(R.id.exit_favorite_activity_button).setOnClickListener {
            this.finish()
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (!spinner.selectedItem.equals("")) {
                    if (isFruit) {
                        Toast.makeText(
                            applicationContext,
                            "Favorite fruit: ${spinner.selectedItem}",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Favorite flower: ${spinner.selectedItem}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}