package com.example.ca2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.*
import androidx.core.widget.addTextChangedListener
import com.github.ybq.android.spinkit.style.DoubleBounce

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val wordsRemaining = findViewById<TextView>(R.id.words_remaining)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val submit = findViewById<Button>(R.id.submit_area)


        //progress bar
        var total_words = 50
        val edtText = findViewById<EditText>(R.id.edtText)
        var prev_words_count = 0;
        edtText.addTextChangedListener {
            val str = edtText.text.toString().trim()
            val delimiter = " "
            val parts = str.split(delimiter)
            wordsRemaining.text = "Words Remaining : " + (total_words - parts.size).toString()
            if (prev_words_count < parts.size) {
                progressBar.incrementProgressBy(2)
                prev_words_count = parts.size
            } else if (prev_words_count > parts.size) {
                progressBar.incrementProgressBy(-2)
                prev_words_count = parts.size
            }

            if (total_words - 49 < parts.size) {
                submit.isEnabled = true
            }
        }

        //Custom Toast
        submit.setOnClickListener {
            val vg: ViewGroup? = findViewById(R.id.Custom_toast)
            val inflater = layoutInflater
            val layout: View = inflater.inflate(R.layout.custom_toast_layout, vg)
            val toast = Toast(applicationContext)
            toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0)
            toast.duration = Toast.LENGTH_LONG
            toast.view = layout
            toast.show()
            val intent = Intent(applicationContext, rateOurApp::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_instructions) {
            val vg: ViewGroup? = findViewById(R.id.instructions_toast)
            val inflater = layoutInflater
            val layout: View = inflater.inflate(R.layout.custom_toast_layout1, vg)
            val toast = Toast(applicationContext)
            toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0)
            toast.duration = Toast.LENGTH_LONG
            toast.view = layout
            toast.show()
            return true
        } else if (id == R.id.time_remaining) {
            Toast.makeText(this, "😮😮😮😮😮 15 Minutes Remaining 😮😮😮😮😮!!",
            Toast.LENGTH_LONG).show()
            return true
        }

        return super.onOptionsItemSelected(item)
    }


}

