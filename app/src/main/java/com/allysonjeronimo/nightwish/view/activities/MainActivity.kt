package com.allysonjeronimo.nightwish.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.allysonjeronimo.nightwish.R
import com.allysonjeronimo.nightwish.model.entities.Album
import com.allysonjeronimo.nightwish.view.fragments.AlbumDetailsFragment
import com.allysonjeronimo.nightwish.view.fragments.AlbumListFragment

class MainActivity : AppCompatActivity(), AlbumListFragment.OnAlbumClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.root, AlbumListFragment.newInstance(), AlbumListFragment.TAG)
                .commit()
        }
    }

    override fun onAlbumClick(album: Album) {

        val albumDetailsFragment = AlbumDetailsFragment.newInstance(album.id)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.root, albumDetailsFragment, AlbumDetailsFragment.TAG)
            .addToBackStack(null)
            .commit()
    }

}