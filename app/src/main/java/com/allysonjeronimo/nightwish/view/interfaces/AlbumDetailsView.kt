package com.allysonjeronimo.nightwish.view.interfaces

import com.allysonjeronimo.nightwish.model.entities.Album

interface AlbumDetailsView {
    fun showDetails(album: Album)
    fun errorAlbumNotFound()
}