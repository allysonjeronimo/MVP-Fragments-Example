package com.allysonjeronimo.nightwish.model.entities

import java.io.Serializable

data class Album(
    var id:Long = 0L,
    var title:String = "",
    var year:Int = 0,
    var coverId:Int = 0,
    var description:String = "",
    var tracks:MutableList<Track>? = null
) : Serializable