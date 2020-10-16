package com.allysonjeronimo.nightwish.model.db.interfaces

import com.allysonjeronimo.nightwish.model.entities.Album

interface AlbumRepository {
    fun findById(id:Long) : Album?
    fun findAll() : List<Album>
}