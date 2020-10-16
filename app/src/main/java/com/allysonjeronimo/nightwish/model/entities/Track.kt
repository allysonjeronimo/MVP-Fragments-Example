package com.allysonjeronimo.nightwish.model.entities

import java.io.Serializable

data class Track (
    var discNumber:Int = 1,
    var title:String = "",
    var length:String = ""
) : Serializable