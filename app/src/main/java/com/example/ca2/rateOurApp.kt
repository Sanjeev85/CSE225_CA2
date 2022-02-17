package com.example.ca2

import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class rateOurApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_our_app)


        val rating1 = findViewById<RatingBar>(R.id.ratingBar1)
        val rating2 = findViewById<RatingBar>(R.id.ratingBar2)
        val rating3 = findViewById<RatingBar>(R.id.ratingBar3)
        val submit = findViewById<Button>(R.id.submit_feedback)
        rating1.setOnRatingBarChangeListener { ratingbar, rating, fromUser ->
            Toast.makeText(this, "rating ${ratingbar.numStars} 🥰🥰🥰🥰", Toast.LENGTH_LONG).show()
        }
        rating2.setOnRatingBarChangeListener { ratingbar, rating, fromUser ->
            Toast.makeText(this, "rating ${ratingbar.numStars} 🥰🥰🥰🥰", Toast.LENGTH_LONG).show()
        }
        rating3.setOnRatingBarChangeListener { ratingbar, rating, fromUser ->
            Toast.makeText(this, "rating ${ratingbar.numStars} 🥰🥰🥰🥰", Toast.LENGTH_LONG).show()
        }
        submit.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "🤗🤗🤗🤗Thanks For Using Our Assignment 🤗🤗🤗🤗",
                Toast.LENGTH_LONG
            ).show()
            finish()
        }

    }
}