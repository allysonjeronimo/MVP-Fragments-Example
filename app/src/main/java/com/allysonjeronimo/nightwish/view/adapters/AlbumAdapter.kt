package com.allysonjeronimo.nightwish.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allysonjeronimo.nightwish.R
import com.allysonjeronimo.nightwish.model.entities.Album
import com.allysonjeronimo.nightwish.view.fragments.AlbumListFragment
import kotlinx.android.synthetic.main.item_list_album.view.*

class AlbumAdapter(
    var albuns:List<Album>,
    var listener : AlbumListFragment.OnAlbumClickListener) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_album, parent, false)
        val viewHolder = ViewHolder(view)

        viewHolder.itemView.setOnClickListener {
            listener.onAlbumClick(albuns[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(albuns[position])
    }

    override fun getItemCount(): Int = albuns.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ivCover = itemView.iv_cover
        val tvTitle = itemView.tv_title
        val tvYear = itemView.tv_year

        fun bind(album:Album){
            ivCover.setImageResource(album.coverId)
            tvTitle.text = album.title
            tvYear.text = album.year.toString()
        }
    }
}