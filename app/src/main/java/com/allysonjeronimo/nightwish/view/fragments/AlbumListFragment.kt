package com.allysonjeronimo.nightwish.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.allysonjeronimo.nightwish.R
import com.allysonjeronimo.nightwish.model.entities.Album
import com.allysonjeronimo.nightwish.model.db.repositories.AlbumRepositoryImpl
import com.allysonjeronimo.nightwish.presenter.AlbumListPresenter
import com.allysonjeronimo.nightwish.view.adapters.AlbumAdapter
import com.allysonjeronimo.nightwish.view.interfaces.AlbumListView
import kotlinx.android.synthetic.main.fragment_album_list.*
import kotlinx.android.synthetic.main.fragment_album_list.view.*

class AlbumListFragment : Fragment(), AlbumListView {

    private val presenter = AlbumListPresenter(this, AlbumRepositoryImpl())

    companion object{
        const val TAG = "AlbunsFragment"
        fun newInstance() = AlbumListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadAlbums()
    }

    override fun showAlbums(albums: List<Album>) {
        rv_albuns.layoutManager = LinearLayoutManager(activity as Context)
        rv_albuns.adapter = AlbumAdapter(albums, activity as OnAlbumClickListener)
    }

    interface OnAlbumClickListener{
        fun onAlbumClick(album: Album)
    }
}