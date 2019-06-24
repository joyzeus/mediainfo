package com.jay.mediainfo

import android.view.View
import android.widget.Button
import android.widget.TextView
import com.jay.base.ui.BaseActivity
import com.jay.ffmpeg.FfmpegJni

/**
 *
 * @ProjectName:    TikTok$
 * @Package:        com.jay.mediainfo$
 * @ClassName:      FfmpegInfoActivity$
 * @Author:         zhouxu
 * @CreateDate:     2019/6/24$ 15:42$
 * @Version:        1.0
 */
class FfmpegInfoActivity() : BaseActivity(), View.OnClickListener {

    var contentView: TextView? = null;

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.compileInfo -> contentView!!.text = FfmpegJni.avCodecConfiguration()
            R.id.formatInfo -> contentView!!.text = FfmpegJni.avFormatInfo()
            R.id.codecInfo -> contentView!!.text = FfmpegJni.avCodecInfo()
            R.id.filterInfo -> contentView!!.text = FfmpegJni.avFilterInfo()
            R.id.protocolInfo -> contentView!!.text = FfmpegJni.avProtocolInfo()
            R.id.configurationInfo -> contentView!!.text = FfmpegJni.avConfigurationInfo()
        }
    }

    override fun layoutId(): Int {
        return R.layout.activity_ffmpeg_info
    }

    override fun init() {
        contentView = findViewById<TextView>(R.id.contentView)
        findViewById<Button>(R.id.compileInfo).setOnClickListener(this@FfmpegInfoActivity)
        findViewById<Button>(R.id.formatInfo).setOnClickListener(this@FfmpegInfoActivity)
        findViewById<Button>(R.id.codecInfo).setOnClickListener(this@FfmpegInfoActivity)
        findViewById<Button>(R.id.filterInfo).setOnClickListener(this@FfmpegInfoActivity)
        findViewById<Button>(R.id.protocolInfo).setOnClickListener(this@FfmpegInfoActivity)
        findViewById<Button>(R.id.configurationInfo).setOnClickListener(this@FfmpegInfoActivity)
    }
}