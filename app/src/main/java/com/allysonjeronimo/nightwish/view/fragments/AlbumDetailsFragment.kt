package com.allysonjeronimo.nightwish.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.allysonjeronimo.nightwish.R
import com.allysonjeronimo.nightwish.model.db.repositories.AlbumRepositoryImpl
import com.allysonjeronimo.nightwish.model.entities.Album
import com.allysonjeronimo.nightwish.presenter.AlbumDetailsPresenter
import com.allysonjeronimo.nightwish.view.adapters.TrackAdapter
import com.allysonjeronimo.nightwish.view.interfaces.AlbumDetailsView
import kotlinx.android.synthetic.main.fragment_album_details.*
import kotlinx.android.synthetic.main.item_list_album.*
import kotlinx.android.synthetic.main.item_list_album.iv_cover
import kotlinx.android.synthetic.main.item_list_album.tv_title

class AlbumDetailsFragment : Fragment(), AlbumDetailsView{

    private val presenter = AlbumDetailsPresenter(this, AlbumRepositoryImpl())

    companion object{
        const val TAG = "AlbumDetailsFragment"
        fun newInstance(albumId:Long) : AlbumDetailsFragment{
            val fragment = AlbumDetailsFragment()
            val extras = Bundle()
            extras.putLong("album_id", albumId)
            fragment.arguments = extras
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_album_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val albumId = arguments!!.getLong("album_id", 0L)
        presenter.loadDetails(albumId)
    }

    override fun showDetails(album: Album) {
        if(album != null){
            iv_cover.setImageResource(album.coverId)
            tv_title.text = album.title
            tv_lancamento.text = "Ano de Lançamento: ${album.year}"
            rv_tracks.layoutManager = LinearLayoutManager(activity as Context)
            rv_tracks.adapter = TrackAdapter(album.tracks!!.toMutableList())
            rv_tracks.isNestedScrollingEnabled = false
        }
    }

    override fun errorAlbumNotFound() {
        Toast.makeText(requireContext(), "Erro: Album não encontrado.", Toast.LENGTH_SHORT).show()
    }
}