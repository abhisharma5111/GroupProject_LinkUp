package com.example.groupproject_linkup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private var adapter:PostAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val query = FirebaseDatabase.getInstance().reference.child("candidatedata")

        val options =FirebaseRecyclerOptions.Builder<Candidate>().setQuery(query, Candidate::class.java).build()
        adapter = PostAdapter(options)

        val rViewPost: RecyclerView = findViewById(R.id.rViewPost)
        rViewPost.layoutManager = LinearLayoutManager(this)
        rViewPost.adapter = adapter
        val redirectButton: Button = findViewById(R.id.redirectCandidatebtn)
        redirectButton.setOnClickListener {
            // Intent to start the new activity
            val intent = Intent(this, CandidateActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }
}