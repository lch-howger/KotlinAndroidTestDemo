package com.lich.kotlinandroidtestdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.net.HttpURLConnection
import java.util.*
import kotlin.concurrent.thread


/**
 * Created by lichhowger on 2020/11/9.
 */
class TestActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }

    fun test01(view: View) {

        var client =  OkHttpClient()
        var requestBody =  MultipartBody.Builder()
            .setType(MultipartBody.FORM)
//            .addFormDataPart("file", "",
//                RequestBody.create("multipart/form-data".toMediaTypeOrNull(), new File(filePath)))
            .addFormDataPart("ipfs-path","QmbKfvFbevpfihWwFWjX7xC6rBAhz7oL56wQusyJ9ycuFj")
            .build()

        var request = Request.Builder()
            .header("Authorization", "Client-ID " + UUID.randomUUID())
            .url("http://18.166.56.133:5001/api/v0/cat")
            .post(requestBody)
            .build()

        var response = client.newCall(request).execute();

        val body = response.body
        val toString = body.toString()

    }

    fun test02(view: View) {
        Thread {         var client =  OkHttpClient()
            var requestBody =  MultipartBody.Builder()
                .setType(MultipartBody.FORM)
//            .addFormDataPart("file", "",
//                RequestBody.create("multipart/form-data".toMediaTypeOrNull(), new File(filePath)))
                .addFormDataPart("ipfs-path","QmbKfvFbevpfihWwFWjX7xC6rBAhz7oL56wQusyJ9ycuFj")
                .build()

            var request = Request.Builder()
                .header("Authorization", "Client-ID " + UUID.randomUUID())
                .url("http://18.166.56.133:5001/api/v0/cat")
                .post(requestBody)
                .build()

            var response = client.newCall(request).execute();

            val body = response.body
            val toString = body.toString()}.start()
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