package com.allysonjeronimo.nightwish.model.db.repositories

import com.allysonjeronimo.nightwish.R
import com.allysonjeronimo.nightwish.model.db.interfaces.AlbumRepository
import com.allysonjeronimo.nightwish.model.entities.Album
import com.allysonjeronimo.nightwish.model.entities.Track

class AlbumRepositoryImpl : AlbumRepository{

    val albums = mutableListOf<Album>()

    init {

        var trackList = mutableListOf<Track>(
            Track(1, "Music", "07:23"),
            Track(1, "Noise", "05:40"),
            Track(1, "Shoemaker", "05:19"),
            Track(1, "Harvest", "05:13"),
            Track(1, "Pan", "05:18"),
            Track(1, "How's The Heart?", "05:02"),
            Track(1, "Procession", "05:31"),
            Track(1, "Tribal", "03:56"),
            Track(1, "Endlessness", "07:11"),
            Track(2, "All The Works Of Nature Which Adorn The World – Vista", "03:59"),
            Track(2, "All The Works Of Nature Which Adorn The World – The Blue", "03:35"),
            Track(2, "All The Works Of Nature Which Adorn The World – The Green", "04:42"),
            Track(2, "All The Works Of Nature Which Adorn The World – Moors", "04:44"),
            Track(2, "All The Works Of Nature Which Adorn The World – Aurorae", "02:07"),
            Track(2, "All The Works Of Nature Which Adorn The World – Quiet As The Snow", "04:05"),
            Track(2, "All The Works Of Nature Which Adorn The World – Anthropocene (incl. “Hurrian Hymn To Nikkal”)", "03:05"),
            Track(2, "All The Works Of Nature Which Adorn The World – Ad Astra", "04:41"),
        )

        albums.add(Album(11, "Human Nature", 2020, R.drawable.human_nature, "", trackList))
        albums.add(Album(10, "Decades", 2019, R.drawable.decades, "", trackList))
        albums.add(Album(9, "Once", 2015, R.drawable.endless_forms_most_beautiful, "", trackList))
        albums.add(Album(8, "Imaginaerum", 2011, R.drawable.imaginaerum, "", trackList))
        albums.add(Album(7, "Dark Passion Play", 2007, R.drawable.dark_passion_play, "", trackList))
        albums.add(Album(6, "End of an Era", 2006, R.drawable.end_of_an_era, "", trackList))
        albums.add(Album(5, "Once", 2004, R.drawable.once, "", trackList))
        albums.add(Album(4, "Century Child", 2002, R.drawable.century_child, "", trackList))
        albums.add(Album(3, "Wishmaster", 2000, R.drawable.wishmaster, "", trackList))
        albums.add(Album(2, "Oceanborn", 1998, R.drawable.oceanborn, "", trackList))
        albums.add(Album(1, "Angels Fall First", 1997, R.drawable.angels_fall_first, "", trackList))
    }

    override fun findById(id: Long): Album? {
        return albums.find { it.id == id }
    }

    override fun findAll() : List<Album>{
        return albums
    }
}