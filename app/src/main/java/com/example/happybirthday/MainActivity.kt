package com.example.happybirthday

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    class Dice(private val sides: Int = 6) {
        fun roll(): Int {
            return (1..sides).random()
        }
    }

    private fun getLuckyNum(diceSides: Int = 6): Int {
        return (1..diceSides).random()
    }

    private fun getDiceImageResource(num: Int): Int {
        val diceImageResource = when (num) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        return diceImageResource
    }

    private fun displayDiceResult(context: Int, result: Int) {

        val diceResultAnimation: ImageView = when (context) {
            1 -> findViewById(R.id.diceImageView1)
            else -> findViewById(R.id.diceImageView2)
        }

        diceResultAnimation.setImageResource(getDiceImageResource(result))
        diceResultAnimation.contentDescription = result.toString()

    }

    private fun rollDice(): Int {
        val dice = Dice()
        return dice.roll()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceButton: Button = findViewById(R.id.dice_button)
        val luckyNumResultTextView: TextView = findViewById(R.id.textView4)

        val initDiceResult = rollDice()

        println("Dice result: $initDiceResult")

        displayDiceResult(1, initDiceResult)
        displayDiceResult(2, initDiceResult)

        diceButton.setOnClickListener {

            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            var diceResult = rollDice()
            displayDiceResult(1, diceResult)
            diceResult = rollDice()
            displayDiceResult(2, diceResult)

            val num = getLuckyNum()

            if (diceResult == num) {
                luckyNumResultTextView.text =
                    diceResult.toString() + getString(R.string.lucky_number_result_win)
            } else {
                luckyNumResultTextView.text =
                    diceResult.toString() + getString(R.string.lucky_number_result_lose)
            }
        }


    }
}