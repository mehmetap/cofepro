package com.example.coffeeorderpro

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.widget.*

class MainActivity : Activity() {
    private val names = listOf("Türk Kahvesi", "Espresso", "Latte", "Cappuccino", "Americano")
    private val prices = listOf(60, 75, 100, 95, 80)
    private var quantity = 1
    private lateinit var nameInput: EditText
    private lateinit var tableInput: EditText
    private lateinit var coffeeSpinner: Spinner
    private lateinit var quantityText: TextView
    private lateinit var totalText: TextView
    private lateinit var cream: CheckBox
    private lateinit var chocolate: CheckBox

    private fun total(): Int = (prices[coffeeSpinner.selectedItemPosition] +
        (if (cream.isChecked) 15 else 0) + (if (chocolate.isChecked) 20 else 0)) * quantity

    private fun refresh() {
        quantityText.text = quantity.toString()
        totalText.text = "${total()} ₺"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameInput = findViewById(R.id.customerName)
        tableInput = findViewById(R.id.tableNumber)
        coffeeSpinner = findViewById(R.id.coffeeSpinner)
        quantityText = findViewById(R.id.quantityText)
        totalText = findViewById(R.id.totalText)
        cream = findViewById(R.id.creamCheck)
        chocolate = findViewById(R.id.chocolateCheck)
        coffeeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, names)
        coffeeSpinner.onItemSelectedListener = object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: android.widget.AdapterView<*>?, view: android.view.View?, position: Int, id: Long) = refresh()
            override fun onNothingSelected(parent: android.widget.AdapterView<*>?) = Unit
        }
        findViewById<Button>(R.id.plusButton).setOnClickListener { quantity++; refresh() }
        findViewById<Button>(R.id.minusButton).setOnClickListener { quantity = (quantity - 1).coerceAtLeast(1); refresh() }
        cream.setOnCheckedChangeListener { _, _ -> refresh() }
        chocolate.setOnCheckedChangeListener { _, _ -> refresh() }
        findViewById<Button>(R.id.orderButton).setOnClickListener {
            val customer = nameInput.text.toString().trim()
            val table = tableInput.text.toString().trim()
            if (customer.isBlank()) { nameInput.error = "Müşteri adı gerekli"; return@setOnClickListener }
            if (table.isBlank() || table.toIntOrNull() == null || table.toInt() <= 0) {
                tableInput.error = "Geçerli masa numarası girin"; return@setOnClickListener
            }
            val extras = listOfNotNull(if (cream.isChecked) "Krema" else null, if (chocolate.isChecked) "Çikolata" else null).ifEmpty { listOf("Yok") }.joinToString(", ")
            AlertDialog.Builder(this).setTitle("Sipariş özeti")
                .setMessage("Müşteri: $customer\nMasa: $table\nKahve: ${names[coffeeSpinner.selectedItemPosition]}\nAdet: $quantity\nEkstralar: $extras\nToplam: ${total()} ₺\n\nDemo: sipariş sunucuya gönderilmez.")
                .setPositiveButton("Tamam", null).show()
        }
        findViewById<Button>(R.id.resetButton).setOnClickListener {
            nameInput.text.clear(); tableInput.text.clear(); coffeeSpinner.setSelection(0)
            quantity = 1; cream.isChecked = false; chocolate.isChecked = false; refresh()
        }
        refresh()
    }
}
