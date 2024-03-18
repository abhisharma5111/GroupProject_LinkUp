package com.example.groupproject_linkup

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


class PostAdapter( options: FirebaseRecyclerOptions<Candidate>) : FirebaseRecyclerAdapter<Candidate, PostAdapter.PostViewHolder>(options){


    class PostViewHolder(inflater: LayoutInflater,parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.post_activity_layout,parent,false)) {

        val candidateName: TextView = itemView.findViewById(R.id.candidatename)
        val postdesc: TextView = itemView.findViewById(R.id.postdesc)
        val postimg : ImageView = itemView.findViewById(R.id.image)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.post_activity_layout, parent, false)
        return PostViewHolder(inflater, parent)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int, model: Candidate) {
        val storageRef: StorageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.postimg)
        Glide.with(holder.postimg.context).load(storageRef).into(holder.postimg)
        holder.candidateName.text = model.candidatename
        holder.postdesc.text = model.title

    }

}


