package com.example.groupproject_linkup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class PostAdapter( options: FirebaseRecyclerOptions<Candidate>) : FirebaseRecyclerAdapter<Candidate, PostAdapter.PostViewHolder>(options) {
    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val candidateName: TextView = itemView.findViewById(R.id.candidateName)
        val title: TextView = itemView.findViewById(R.id.title)
        val photo : ImageView = itemView.findViewById(R.id.photo)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_main, parent, false)
        return PostViewHolder(view)
    }
}