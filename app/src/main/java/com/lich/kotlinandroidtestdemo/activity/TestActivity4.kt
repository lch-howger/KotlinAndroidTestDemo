package com.lich.kotlinandroidtestdemo.activity

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.SystemClock.sleep
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lich.kotlinandroidtestdemo.R
import com.lich.kotlinandroidtestdemo.utils.PathUtils
import kotlinx.android.synthetic.main.activity_test.*
import java.io.*


/**
 * Created by lichhowger on 2020/11/9.
 */
class TestActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        pb.setProgress(10)
        sleep(500)
        pb.setProgress(20)
        sleep(500)
        pb.setProgress(30)
        sleep(500)
        pb.setProgress(40)
        sleep(500)
        pb.setProgress(0)
        var msg=Message()
        msg.what = 0
        msg.arg1=10
        handler.sendMessage(msg)
    }

    val handler=object :Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == 0) {

            }
        }
    }

    fun test01(view: View) {
        var bytes = byteArrayOf(43, 43, 54, 64, 63, 54, 64, 25, 45)
        val input = ByteArrayInputStream(bytes)
        val out = FileOutputStream(File(PathUtils.getPath(this, "afjkd.ads")))
        var arr = ByteArray(1)
        var n = -1
        var total: Double = 0.0
        var big: Double = bytes.size.toDouble()
        while (true) {
            n = input.read(arr, 0, arr.size)
            if (n == -1) {
                break
            }
            out.write(arr, 0, n)
            sleep(300)
            total+=arr.size
            pb.setProgress(((total / big) * 100.0).toInt())
        }
        input.close()
        out.close()
    }

    fun test02(view: View) {
    }

    fun test03(view: View) {


    }

    fun test04(view: View) {
    }

    fun test05(view: View) {
    }

    fun test06(view: View) {
        Thread { }.start()
    }
}