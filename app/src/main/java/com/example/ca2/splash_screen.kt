package com.example.ca2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class splash_screen : AppCompatActivity() {
    private val TIME__OUT:Long = 5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler().postDelayed({
            val intent = Intent(applicationContext, UserAgreement::class.java)
            startActivity(intent)
            finish()
        }, TIME__OUT)
    }
}