package com.example.happybirthday

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    class Dice(val sides: Int = 6) {
        fun roll(): Int {
            return (1..sides).random()
        }
    }

    fun rollDice(): Int {
        val dice = Dice()
        return dice.roll()
    }

    fun luckyNum(diceSides: Int = 6): Int {
        return (1..diceSides).random()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceButton: Button = findViewById(R.id.dice_button)
        val luckyNumResultTextView: TextView = findViewById(R.id.textView4)

        diceButton.setOnClickListener {

            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            val diceResult = rollDice()
            val diceResultTextView: TextView = findViewById(R.id.textView3)
            diceResultTextView.text = diceResult.toString()

            luckyNumResultTextView.text = if (diceResult == luckyNum()) getString(R.string.lucky_number_result) else ""
        }

    }
}