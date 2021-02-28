package com.taxitech.taxiboard.deema

import agency.deema.sdk.Ads
import agency.deema.sdk.DeemaVideoListener
import agency.deema.sdk.Video
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), DeemaVideoListener {
    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var video: Video

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDeema()
    }

    private fun initDeema() {
        val placementId = "ID#2033"

        val deema = Ads(this)
        video = deema.createVideo()
                .setPlacementId(placementId)
                .setCallBack(this)
                .setPreloadDisabled(true)
                .setActivity(this)
                .build()

        video.play()
    }

    override fun videoReady() {
        Log.d(TAG, "videoReady: ")
    }

    override fun videoError(p0: String?) {
        Log.d(TAG, "videoError: $p0")
    }

    override fun videoClick() {
        Log.d(TAG, "videoClick: ")
    }

    override fun videoComplete() {
        Log.d(TAG, "videoComplete: ")
    }

    override fun videoDismiss() {
        Log.d(TAG, "videoDismiss: ")
    }

    override fun playRequestCanceled() {
        Log.d(TAG, "playRequestCanceled: ")
    }
}