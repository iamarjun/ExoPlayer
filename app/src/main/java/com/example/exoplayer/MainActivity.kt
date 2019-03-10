package com.example.exoplayer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.exoplayer.utils.Resources
import com.example.exoplayer.utils.VerticalSpacingItemDecorator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initVideoPlayer()
    }

    private fun initVideoPlayer() {
        video_player.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        video_player.addItemDecoration(VerticalSpacingItemDecorator(10))
        video_player.setMediaObjects(Resources.MEDIA_OBJECTS)
        video_player.adapter = VideoPlayerAdapter(Resources.MEDIA_OBJECTS, initGlide())
    }

    private fun initGlide(): RequestManager {
        val options = RequestOptions()
            .placeholder(R.drawable.white_background)
            .error(R.drawable.white_background)

        return Glide.with(this)
            .setDefaultRequestOptions(options)
    }

    override fun onDestroy() {
        video_player?.let {
            video_player.releasePlayer()
        }
        super.onDestroy()
    }
}
