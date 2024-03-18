package com.example.groupproject_linkup

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val candidate = intent.getParcelableExtra<Candidate>("candidate")

        findViewById<TextView>(R.id.detailName).text = candidate?.candidatename
        findViewById<TextView>(R.id.detailDiscription).text = candidate?.description
        findViewById<TextView>(R.id.detailAddress).text = candidate?.address
        findViewById<TextView>(R.id.detailTitle).text = candidate?.title
        findViewById<TextView>(R.id.detailEmail).text = candidate?.email
        findViewById<TextView>(R.id.detailExperience).text = candidate?.experience

        Glide.with(this)
            .load(candidate?.image)
            .into(findViewById<ImageView>(R.id.image))
    }
}