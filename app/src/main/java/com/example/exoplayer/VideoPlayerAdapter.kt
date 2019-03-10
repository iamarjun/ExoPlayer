package com.example.exoplayer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.example.exoplayer.model.Media
import kotlinx.android.synthetic.main.layout_video_list_item.view.*
import com.example.exoplayer.VideoPlayerAdapter.VideoPlayerViewHolder



class VideoPlayerAdapter(private val mediaList: List<Media>, private val requestManager: RequestManager) :
    RecyclerView.Adapter<VideoPlayerAdapter.VideoPlayerViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VideoPlayerViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.layout_video_list_item, p0, false)

        return VideoPlayerViewHolder(view, requestManager)
    }

    override fun getItemCount(): Int = mediaList.size

    override fun onBindViewHolder(p0: VideoPlayerViewHolder, p1: Int) {
        p0.onBind(mediaList[p1], requestManager)
    }


    inner class VideoPlayerViewHolder(val view: View, val requestManager: RequestManager) :
        RecyclerView.ViewHolder(view) {

        val mediaContainer = view.media_container
        val parent = view
        val title = view.title
        val thumbnail = view.thumbnail
        val volumeControl = view.volume_control
        val progressBar = view.progressBar

        fun onBind(media: Media, requestManager: RequestManager) {
            view.tag = this
            title.text = media.title
            requestManager
                .load(media.thumbnail)
                .into(thumbnail)
        }

    }
}