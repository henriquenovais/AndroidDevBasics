package com.example.tiptime

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{ calculateTip() }

        binding.costOfServiceEditText.setOnKeyListener{ view, keyCode, _ -> handleKeyEvent(view, keyCode)}
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun calculateTip () {
        val costInTextField = binding.costOfServiceEditText.text.toString()
        /*
        //Custom nullsafe solution using "Java-based" logic:
        var cost : Double = 0.00
        if (costInTextField == "") {
            binding.tipAmount.text = ""
            return
        } else {
            cost = costInTextField.toDouble()
        }
        */
        val cost = costInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipAmount.text = "" // for use case when the user excludes service cost and calculates tip again after a first calculation
            return //exit the method without executing the rest of it
        }

        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.radio_twenty -> 0.2
            R.id.radio_fifteen -> 0.15
            else -> 0.10
        }
        var tip = tipPercentage * cost
        if (binding.switchRoundup.isChecked) {
            tip = kotlin.math.ceil(tip)
        }
        displayTip(tip)
    }

    private fun displayTip (tip : Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipAmount.text = getString(R.string.tip_amount, formattedTip)
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}