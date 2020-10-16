package com.allysonjeronimo.nightwish.view.interfaces

import com.allysonjeronimo.nightwish.model.entities.Album

interface AlbumListView {
    fun showAlbums(albums:List<Album>)
}