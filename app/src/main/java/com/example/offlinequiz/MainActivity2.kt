package com.example.offlinequiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    private lateinit var questions: List<Question>
    var selectContinentName = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val amerikaLinear = findViewById<LinearLayout>(R.id.amerika)
        val amerikaText = findViewById<TextView>(R.id.amerika_text)

        val afrikaLinear = findViewById<LinearLayout>(R.id.afrika)
        val afrikaText = findViewById<TextView>(R.id.afrika_text)

        val asiaLinear = findViewById<LinearLayout>(R.id.asia)
        val asiaText = findViewById<TextView>(R.id.asia_text)

        val evropaLinear = findViewById<LinearLayout>(R.id.europe)
        val evropaText = findViewById<TextView>(R.id.europe_text)

        val name = intent.getStringExtra(Continents.name)
        amerikaLinear.setOnClickListener {
            questions = Continents.getQuestionAmerica()
            selectContinentName = amerikaText.text.toString()
            val intent = Intent(this,MainActivity3::class.java)
            intent.putExtra("continent",selectContinentName)
            intent.putExtra(Continents.name,name)
            startActivity(intent)
        }
        afrikaLinear.setOnClickListener {
            selectContinentName = afrikaText.text as String
            val intent = Intent(this,MainActivity3::class.java)
            intent.putExtra("continent",selectContinentName)
            intent.putExtra(Continents.name,name)
            startActivity(intent)
        }
        asiaLinear.setOnClickListener {
            selectContinentName = asiaText.text as String
            val intent = Intent(this,MainActivity3::class.java)
            intent.putExtra("continent",selectContinentName)
            intent.putExtra(Continents.name,name)
            startActivity(intent)
        }
        evropaLinear.setOnClickListener {
            selectContinentName = evropaText.text as String
            val intent = Intent(this,MainActivity3::class.java)
            intent.putExtra("continent",selectContinentName)
            intent.putExtra(Continents.name,name)
            startActivity(intent)
        }
    }
}