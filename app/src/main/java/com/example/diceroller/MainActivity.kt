package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRoll : TextView = findViewById(R.id.btn_roll)
        btnRoll.setOnClickListener {
            rollDice()
        }
        rollDice()
    }
    private fun rollDice() {
        val imgDice : ImageView = findViewById(R.id.img_dice)
        val dice = Dice(6)
        val diceRolled : Int = dice.roll()
        val drawableResource = when (diceRolled) {
            1-> R.drawable.dice_1
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else-> R.drawable.dice_6
        }
        val message = when(diceRolled) {
            6-> "Congrats, you won !"
            else-> "You rolled $diceRolled, try again !"
        }
        imgDice.setImageResource(drawableResource)
        imgDice.contentDescription = diceRolled.toString()
        Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
    }
}