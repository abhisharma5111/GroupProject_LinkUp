package com.example.groupproject_linkup

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import android.widget.Button
import android.view.View


class DetailActivity : AppCompatActivity() {

    private lateinit var connectButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val candidate = intent.getStringExtra("candidate") as Candidate

        findViewById<TextView>(R.id.name).text = candidate.candidateName
        findViewById<TextView>(R.id.description).text = candidate.description
        findViewById<TextView>(R.id.address).text = candidate.address
        findViewById<TextView>(R.id.email).text = candidate.email
        findViewById<TextView>(R.id.experience).text = candidate.experience

        Glide.with(this).load(candidate.image).into(findViewById<ImageView>(R.id.profilePhoto))

        connectButton = findViewById(R.id.connectButton)
//
    }
    fun onConnectButtonClick(view: View) {
        if (connectButton.text == "Connect") {
            connectButton.text = "Connected"
        } else {
            connectButton.text = "Connect"
        }
    }
}
