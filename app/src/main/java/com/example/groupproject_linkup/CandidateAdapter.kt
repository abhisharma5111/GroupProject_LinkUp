package com.example.groupproject_linkup
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import android.content.Intent
import android.view.View
import android.content.Context



class CandidateAdapter( options: FirebaseRecyclerOptions<Candidate>) : FirebaseRecyclerAdapter<Candidate, CandidateAdapter.CardViewHolder>(options){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.candidate_layout, parent, false)
        return CardViewHolder(view)
    }



    override fun onBindViewHolder(holder: CardViewHolder, position: Int, model: Candidate) {

        holder.candidateName.text = model.candidateName
        holder.title.text = model.title
        Glide.with(holder.photo.context).load(model.image).into(holder.photo)

//        holder.itemView.setOnClickListener {
//            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra("candidateName", model.candidateName)
//            intent.putExtra("description", model.description)
//            intent.putExtra("address", model.address)
//            intent.putExtra("title", model.title)
//            intent.putExtra("email", model.email)
//            intent.putExtra("experience", model.experience)
//            intent.putExtra("image", model.image)
//            context.startActivity(intent)
//        }


    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val candidateName: TextView = itemView.findViewById(R.id.candidateName)
        val title: TextView = itemView.findViewById(R.id.title)
        val photo : ImageView = itemView.findViewById(R.id.photo)

    }
}