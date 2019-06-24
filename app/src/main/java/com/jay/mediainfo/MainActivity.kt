package com.jay.mediainfo

import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jay.base.ui.BaseActivity

class MainActivity : BaseActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.ffmpegInfo -> goFfmpegInfoActivity()
        }
    }

    var items = arrayOf("编译信息", "软件支持信息")
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        recyclerView.adapter = ItemAdapter(items.toList())

        findViewById<Button>(R.id.ffmpegInfo).setOnClickListener(this@MainActivity)
    }

    fun goFfmpegInfoActivity() {
        val intent = Intent(this@MainActivity, FfmpegInfoActivity::class.java)
        this@MainActivity.startActivity(intent)
    }
}
