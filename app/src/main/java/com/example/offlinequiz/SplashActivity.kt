package com.example.offlinequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
//        val a = Handler()
//        a.postDelayed({
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        },3000)
//
        Handler(Looper.getMainLooper()).postDelayed({
            // Your Code
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
}