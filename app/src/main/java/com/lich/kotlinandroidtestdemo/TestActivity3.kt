package com.lich.kotlinandroidtestdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_test.*
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.util.*


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