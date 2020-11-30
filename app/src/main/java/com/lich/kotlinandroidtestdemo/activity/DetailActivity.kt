package com.lich.kotlinandroidtestdemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lich.kotlinandroidtestdemo.R
import com.lich.kotlinandroidtestdemo.utils.PathUtils
import kotlinx.android.synthetic.main.activity_detail.*
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File

/**
 * Created by lichhowger on 2020/11/11.
 */
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.extras?.getString("name").toString()
        val hash = intent.extras?.getString("hash").toString()
        val size = intent.extras?.getInt("size")

        tv_name.text = name
        tv_hash.text = hash
        tv_size.text = size.toString()

        getData(hash, name)
    }

    private fun getData(hash: String, name: String) {

        Thread {
            var client = OkHttpClient()
            var requestBody = MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("ipfs-path", hash)
                .build()

            var request = Request.Builder()
                .url("http://18.166.56.133:5001/api/v0/cat")
                .post(requestBody)
                .build()

            var response = client.newCall(request).execute()
            var bytes = response.body?.bytes()

            var file = File(PathUtils.getPath(this, name))
            file.writeBytes(bytes!!)
        }.start()
    }


}