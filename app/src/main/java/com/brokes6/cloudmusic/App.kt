package com.brokes6.cloudmusic

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.brokes6.cloudmusic.manager.MusicManager

/**
 * Author: 付鑫博
 * Version: 1.0.0
 * Date: 2021/11/17
 * Mender:
 * Modify:
 * Description:
 */
class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        var mContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
        initComponent()
    }

    private fun initComponent() {
        MusicManager.instance.init(this)
    }
}