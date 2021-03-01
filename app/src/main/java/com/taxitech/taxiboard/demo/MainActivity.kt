package com.taxitech.taxiboard.demo

import agency.deema.sdk.*
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
        val placementId = "2033"

        val deema = Ads(this)

        val dialogConfig = DialogConfig()
        dialogConfig.title = "back to main"
        dialogConfig.description = "Description"
        dialogConfig.cancelButtonText = "yes"
        dialogConfig.okButtonText = "no"

        video = deema
            .createVideo()
            .setPlacementId(placementId)
            .setActivity(this)
            .setCallBack(this)
            .setShowDialog(true)
            .setPreloadDisabled(false)
            .setBackDisabled(false)
            .setOrientation(VideoOrientation.DEFAULT)
            .setDialogConfig(dialogConfig)
            .build()
    }

    override fun onResume() {
        super.onResume()

        video.play()
    }

    override fun videoReady() {
        Log.d(TAG, "videoReady: ")
    }

    override fun videoError(p0: String?) {
        Log.d(TAG, "videoError: $p0")
    }

    override fun videoComplete(p0: Boolean) {
        Log.d(TAG, "videoComplete: $p0")
    }

    override fun videoClick() {
        Log.d(TAG, "videoClick: ")
    }

    override fun videoDismiss() {
        Log.d(TAG, "videoDismiss: ")
    }

    override fun playRequestCanceled() {
        Log.d(TAG, "playRequestCanceled: ")
    }
}