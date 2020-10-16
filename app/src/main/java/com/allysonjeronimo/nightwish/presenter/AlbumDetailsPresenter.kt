package com.allysonjeronimo.nightwish.presenter

import com.allysonjeronimo.nightwish.model.db.interfaces.AlbumRepository
import com.allysonjeronimo.nightwish.model.entities.Album
import com.allysonjeronimo.nightwish.view.interfaces.AlbumDetailsView

class AlbumDetailsPresenter(
    private val view: AlbumDetailsView,
    private val repository:AlbumRepository
){

    fun loadDetails(albumId:Long){
        val album = repository.findById(albumId)
        if(album != null){
            view.showDetails(album)
        }
        else{
            view.errorAlbumNotFound()
        }
    }
}