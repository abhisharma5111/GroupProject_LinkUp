package com.example.groupproject_linkup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private var adapter: CandidateAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val query = FirebaseDatabase.getInstance().reference.child("candidate")

        val options = FirebaseRecyclerOptions.Builder<Candidate>()
            .setQuery(query, Candidate::class.java)
            .build()
        adapter = CandidateAdapter( options)
//
//        val rViewPost: RecyclerView = findViewById(R.id.rViewPost)
//
//        rViewPost.layoutManager = LinearLayoutManager(this)
//        rViewPost.adapter = adapter
    }
    override fun onStart(){
        super.onStart()
        adapter?.startListening()
    }
}