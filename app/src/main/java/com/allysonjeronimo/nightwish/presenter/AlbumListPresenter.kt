package com.allysonjeronimo.nightwish.presenter

import com.allysonjeronimo.nightwish.model.db.interfaces.AlbumRepository
import com.allysonjeronimo.nightwish.view.interfaces.AlbumListView

class AlbumListPresenter (
    private val view: AlbumListView,
    private val repository: AlbumRepository
) {

    fun loadAlbums(){
        val albums = repository.findAll()
        view.showAlbums(albums)
    }

}