package com.example.groupproject_linkup

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference



class CandidateAdapter(private val context: Context, options: FirebaseRecyclerOptions<Candidate>) : FirebaseRecyclerAdapter<Candidate, CandidateAdapter.CardViewHolder>(options){


    class CardViewHolder(inflater: LayoutInflater,parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.candidate_layout,parent,false)) {

        val candidateName: TextView = itemView.findViewById(R.id.candidatename)
        val title: TextView = itemView.findViewById(R.id.title)
        val photo : ImageView = itemView.findViewById(R.id.photo)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.candidate_layout, parent, false)
        return CardViewHolder(inflater, parent)
    }
    override fun onBindViewHolder(holder: CardViewHolder, position: Int, model: Candidate) {
        val storageRef: StorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.image)
        Glide.with(holder.photo.context).load(storageRef).into(holder.photo)
        holder.candidateName.text = model.candidatename
        holder.title.text = model.title


        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("candidate", model) // Pass the entire Candidate object
            context.startActivity(intent)
        }


    }

}