package com.example.offlinequiz

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
class ResultActiv : AppCompatActivity() {

    companion object {
        const val PREVIOUS_MAX_SCORE = "maxScore"
        const val PREVIOUS_NAME = "name"
    }
    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_results)

        val userName = intent.getStringExtra(Continents.name)
        val congratulationName = findViewById<TextView>(R.id.etName)

        sharedPreferences = getSharedPreferences(PREVIOUS_MAX_SCORE, MODE_PRIVATE)

        congratulationName.text = getString(R.string.congratulation, userName!!.capitalized())

        val userScoreResult = intent.getIntExtra("score",0)
        val userScore = findViewById<TextView>(R.id.score)
        userScore.text = getString(R.string.user_score,userScoreResult)

        sharedPreferences.edit().putInt(PREVIOUS_MAX_SCORE,userScoreResult).apply()
        sharedPreferences.edit().putString(PREVIOUS_NAME,userName).apply()



        val quit = findViewById<Button>(R.id.quit)
        val restart = findViewById<Button>(R.id.restart)

        quit.setOnClickListener {
            moveTaskToBack(true);
            System.exit(1);
        }

        restart.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
    fun String.capitalized(): String {
        return this.replaceFirstChar {
            if (it.isLowerCase())
                it.titlecase(Locale.getDefault())
            else it.toString()
        }
    }
}