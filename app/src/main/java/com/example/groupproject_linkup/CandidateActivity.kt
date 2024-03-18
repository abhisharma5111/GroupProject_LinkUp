package com.example.groupproject_linkup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class CandidateActivity: AppCompatActivity() {
    private var adapter: CandidateAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.candidate_activity)

        val query = FirebaseDatabase.getInstance().reference.child("candidatedata")

        val options = FirebaseRecyclerOptions.Builder<Candidate>()
            .setQuery(query, Candidate::class.java)
            .build()
        adapter = CandidateAdapter( this, options)

        val rViewCandidate: RecyclerView = findViewById(R.id.rViewCandidate)

        rViewCandidate.layoutManager = LinearLayoutManager(this)
        rViewCandidate.adapter = adapter
    }
    override fun onStart(){
        super.onStart()
        adapter?.startListening()
    }
}