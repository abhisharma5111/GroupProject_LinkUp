package com.example.groupproject_linkup

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class IntroActivity : AppCompatActivity() {

    private val splashDisplayLength = 2000 // 2 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        // Post a delayed action to navigate to MainActivity after 2 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Start MainActivity
            val mainIntent = Intent(this@IntroActivity, MainActivity::class.java)
            startActivity(mainIntent)
            finish() // Finish IntroActivity to prevent going back to it using the back button
        }, splashDisplayLength.toLong())
    }
}
