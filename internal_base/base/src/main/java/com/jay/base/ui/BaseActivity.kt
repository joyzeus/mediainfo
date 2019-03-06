package com.jay.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife

abstract class BaseActivity : AppCompatActivity() {

    abstract fun layoutId(): Int

    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        ButterKnife.bind(this)
        init()
    }
}