package com.example.tiptime

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{ calculateTip() }
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun calculateTip () {
        val costInTextField = binding.costOfService.text.toString()
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
}