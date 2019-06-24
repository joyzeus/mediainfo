package com.jay.mediainfo

import android.widget.TextView
import com.jay.base.ui.BaseActivity
import com.jay.ffmpeg.FfmpegJni

class MainActivity : BaseActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        findViewById<TextView>(R.id.mainView).setText(FfmpegJni.avCodecConfiguration())
    }
}
