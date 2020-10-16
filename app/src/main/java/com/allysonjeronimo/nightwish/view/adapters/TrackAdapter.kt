package com.allysonjeronimo.nightwish.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.allysonjeronimo.nightwish.R
import com.allysonjeronimo.nightwish.model.entities.Track
import kotlinx.android.synthetic.main.item_list_album.view.*
import kotlinx.android.synthetic.main.item_list_album.view.tv_title
import kotlinx.android.synthetic.main.item_list_track.view.*

class TrackAdapter(private val tracks:List<Track>) : RecyclerView.Adapter<TrackAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_track, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tracks[position])
    }

    override fun getItemCount() = tracks.size

    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvTitle: TextView = itemView.tv_title
        val tvLength: TextView = itemView.tv_length
        fun bind(track:Track){
            tvTitle.text = track.title
            tvLength.text = if(track.length.isNotEmpty()) track.length else "0:00"
        }
    }


}