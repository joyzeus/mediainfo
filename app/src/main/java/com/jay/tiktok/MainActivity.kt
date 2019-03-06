package com.jay.tiktok

import android.util.Log
import android.widget.TextView
import butterknife.BindView
import com.jay.base.ui.BaseActivity

class MainActivity : BaseActivity() {

    @BindView(R.id.mainView)
    lateinit var mMainView: TextView

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        Log.e("main", mMainView.text.toString())
    }
}
