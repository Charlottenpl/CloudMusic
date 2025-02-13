package com.brookes6.cloudmusic

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.brookes6.cloudmusic.launch.AppStartUtil
import com.brookes6.cloudmusic.launch.task.*
import com.drake.net.scope.NetCoroutineScope
import com.drake.net.utils.scopeNet
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope

/**
 * Author: fuxinbo

 * Date: 2023/1/11

 * Description:
 */
class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var content: Context

        @OptIn(DelicateCoroutinesApi::class)
        val scope by lazy { GlobalScope }
    }

    override fun onCreate() {
        super.onCreate()
        content = this
        AppStartUtil.Instance
            .addTask(MmkvTask(this))
            .addTask(NetTask(this))
            .addTask(RoomTask(this))
            .addTask(MusicTask(this))
            .startTask()
        AppStartUtil.Instance.startLockMainThread()
    }
}