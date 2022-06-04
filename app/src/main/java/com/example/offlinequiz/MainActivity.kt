package com.example.offlinequiz

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var first: EditText
    lateinit var add: Button
    private lateinit var sharedPreferences: SharedPreferences
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        first = findViewById(R.id.birinshi_san)
        add = findViewById(R.id.qosiw)

        val previousName = findViewById<TextView>(R.id.previousName)

        sharedPreferences = getSharedPreferences(ResultActiv.PREVIOUS_MAX_SCORE, MODE_PRIVATE)

        val maxScore = findViewById<TextView>(R.id.max_score_1)

        maxScore.text = "Your previous max score ${sharedPreferences.getInt(ResultActiv.PREVIOUS_MAX_SCORE,0)}"
        previousName.text = "Your previous name ${sharedPreferences.getString(ResultActiv.PREVIOUS_NAME,"")}"

        Log.d("TTTT",maxScore.toString())
//        if (intent.getBooleanExtra("EXIT", false)) {
//            finish();
//        }

        first.addTextChangedListener(textWatcher)

        add.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra(Continents.name,first.text.toString())
            startActivity(intent)
            finish()
        }
    }
    private val textWatcher: TextWatcher = object: TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val inputFirst = first.text.toString().trim()
            add.isEnabled = inputFirst.isNotEmpty()
        }
        override fun afterTextChanged(p0: Editable?) {}
    }

}