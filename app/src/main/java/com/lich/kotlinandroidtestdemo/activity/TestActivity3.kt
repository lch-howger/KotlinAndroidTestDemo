package com.lich.kotlinandroidtestdemo.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lich.kotlinandroidtestdemo.R


/**
 * Created by lichhowger on 2020/11/9.
 */
class TestActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }

    fun test01(view: View) {
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