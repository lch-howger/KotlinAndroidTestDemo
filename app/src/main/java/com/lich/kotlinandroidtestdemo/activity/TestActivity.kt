package com.lich.kotlinandroidtestdemo.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.lich.kotlinandroidtestdemo.entity.IPFSAddEntity
import com.lich.kotlinandroidtestdemo.R
import com.lich.kotlinandroidtestdemo.entity.UrlEntity
import com.lich.kotlinandroidtestdemo.utils.PathUtils
import com.lich.kotlinandroidtestdemo.utils.UrlUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_test.*
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.File
import java.io.IOException
import java.util.*


/**
 * Created by lichhowger on 2020/11/5.
 */
class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        val path = PathUtils.getPath(this, "_abc.png")
        val file = File(path)
        Picasso.get().load(file).into(iv_img)
    }

    fun test01(view: View) {
        Thread {

            val MEDIA_TYPE_MARKDOWN = "text/x-markdown; charset=utf-8".toMediaType()
            var file = File(PathUtils.getPath(this, "_abc.png"))
            var client = OkHttpClient()
            val request = Request.Builder()
                .url("http://18.166.56.133:5001/api/v0/add")
                .post(file.asRequestBody(MEDIA_TYPE_MARKDOWN))
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                try {
                    val string = response.body!!.string()
                    val entity = Gson().fromJson(string, IPFSAddEntity::class.java)
                    handleCopyFile(entity.Hash)
                } catch (e: Exception) {

                }
            }
        }.start()
    }

    fun handleCopyFile(hash: String) {

    }

    fun test02(view: View) {
        Thread {
            var path = PathUtils.getPath(this, "_abc.png")
            var file = File(path)

            val fileBody = file.asRequestBody("multipart/form-data".toMediaTypeOrNull())

            var client = OkHttpClient()
            var requestBody = MultipartBody.Builder().setType(MultipartBody.FORM)
            requestBody.addFormDataPart("file", "files_abc.png", fileBody)
            var body = requestBody.build()

            var request = Request.Builder()
                .url("http://18.166.56.133:5001/api/v0/add")
                .post(body)
                .build()

            var response = client.newCall(request).execute();

            val bytes = response.body?.bytes()
            val string = String(bytes!!)
            val string2 = String(bytes!!)

        }.start()
    }

    fun test03(view: View) {
        Thread {

            val postBody = "".trimMargin()
            var client = OkHttpClient()
            var request = Request.Builder()
                .url("http://18.166.56.133:5001/api/v0/files/cp")
                .addHeader("arg", "/ipfs/QmaY6wh9z8kFoeCJNmh3RauFDfJFb8aRbsP94jLKFzTtBr")
                .addHeader("arg", "/abc.png")
                .post(postBody.toRequestBody())
                .build()

            var response = client.newCall(request).execute();

            val bytes = response.body?.bytes()
            val string = String(bytes!!)
            val jsonObject = JSONObject(string)
            val jsonObject2 = JSONObject(string)

        }.start()

    }

    fun test04(view: View) {
        Thread {
            val formBody = FormBody.Builder()
                .add("arg", "/ipfs/QmaY6wh9z8kFoeCJNmh3RauFDfJFb8aRbsP94jLKFzTtBr")
                .add("arg", "/abc.png")
                .build()
            var client = OkHttpClient()
            var request = Request.Builder()
                .url("http://18.166.56.133:5001/api/v0/files/cp")
                .post(formBody)
                .build()

            var response = client.newCall(request).execute();

            val bytes = response.body?.bytes()
            val string = String(bytes!!)
            val jsonObject = JSONObject(string)
            val jsonObject2 = JSONObject(string)

        }.start()
    }

    fun test05(view: View) {
        Thread {
            var list = mutableListOf<UrlEntity>()
            list.add(UrlEntity("arg", "/ipfs/QmaY6wh9z8kFoeCJNmh3RauFDfJFb8aRbsP94jLKFzTtBr"))
            list.add(UrlEntity("arg", "/abc.png"))
            var url = UrlUtils.getUrl(list, "http://18.166.56.133:5001/api/v0/files/cp")
            val postBody = "".trimMargin()
            var client = OkHttpClient()
            var request = Request.Builder()
                .url(url)
                .post(postBody.toRequestBody())
                .build()

            var response = client.newCall(request).execute();

            val bytes = response.body?.bytes()
            if (response.code == 200) {
                showToast("chengg")
            }else if (response.code == 500) {

            }

        }.start()
    }

    fun test06(view: View) {
        val queue = Volley.newRequestQueue(this)
        val url = "http://18.166.56.133:5001/api/v0/cat"
        val stringRequest = object : StringRequest(com.android.volley.Request.Method.POST, url,
            Response.Listener<String> { response ->
                tv.setText("Response is: ${response.substring(0, 500)}")
            },
            Response.ErrorListener {
                var str = String(it.networkResponse.data)
                tv.setText(str)
            }) {
            override fun getBodyContentType(): String {
                val boundary = "-----------------" + UUID.randomUUID().toString()
                return "text/plain; boundary=" + boundary;
            }

            override fun getParams(): MutableMap<String, String> {
                var map = mutableMapOf<String, String>()
                map.put("ipfs-path", "QmbKfvFbevpfihWwFWjX7xC6rBAhz7oL56wQusyJ9ycuFj")
                return map
            }
        }
        queue.add(stringRequest)
    }

//    var handler: Handler = object : Handler() {
//        override fun handleMessage(msg: Message) {
//            super.handleMessage(msg)
////            var imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
////            et.requestFocus()
////            imm.showSoftInput(et, 0)
//        }
//    }

    fun showToast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }
}