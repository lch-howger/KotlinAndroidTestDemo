package com.lich.kotlinandroidtestdemo.utils

import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.lich.kotlinandroidtestdemo.entity.IPFSEntity
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject
import java.lang.Exception

/**
 * Created by lichhowger on 2020/11/10.
 */
class HttpUtils(ctx: AppCompatActivity) {

    var ctx: AppCompatActivity = ctx
    var url: String = ""
    var params = mutableMapOf<String, String>()

    private lateinit var onSuccess: (String) -> Unit
    private lateinit var onFail: (String) -> Unit
    private lateinit var onLoad: (Response) -> Unit

    fun url(url: String): HttpUtils {
        this.url = url
        return this
    }

    fun add(key: String, value: String): HttpUtils {
        params[key] = value
        return this
    }

    fun post(success: (result: String) -> Unit, fail: (result: String) -> Unit) {
        this.onSuccess = success
        this.onFail = fail

        Thread {
            var client = OkHttpClient()
            var requestBody = MultipartBody.Builder().setType(MultipartBody.FORM)
            params.forEach {
                requestBody.addFormDataPart(it.key, it.value)
            }
            var body = requestBody.build()

            var request = Request.Builder()
                .url(url)
                .post(body)
                .build()

            var response = client.newCall(request).execute();

            val bytes = response.body?.bytes()
            try {
                val string = String(bytes!!)
                val jsonObject = JSONObject(string)
                val objects = jsonObject.getJSONObject("Objects")
                val keys = objects.keys()
                val next = keys.next()
                val obj = objects.getJSONObject(next)
                val entity = Gson().fromJson(obj.toString(), IPFSEntity::class.java)
                val links = entity.Links
                ctx.runOnUiThread { onSuccess(obj.toString()) }

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }.start()
    }

    fun simplePost(
        success: (result: String) -> Unit,
        fail: (result: String) -> Unit
    ) {
        this.onSuccess = success
        this.onFail = fail

        Thread {
            val postBody = "".trimMargin()
            var client = OkHttpClient()
            var request = Request.Builder()
                .url(url)
                .post(postBody.toRequestBody())
                .build()

            var response = client.newCall(request).execute();

            val bytes = response.body?.bytes()
            val string = String(bytes!!)
            val jsonObject = JSONObject(string)
            var obj = jsonObject.getString("Entries")
            ctx.runOnUiThread { onSuccess(obj) }

        }.start()
    }

    fun post(
        url: String,
        success: (result: String) -> Unit,
        fail: (result: String) -> Unit
    ) {
        this.onSuccess = success
        this.onFail = fail

        Thread {
            val postBody = "".trimMargin()
            var client = OkHttpClient()
            var request = Request.Builder()
                .url(url)
                .post(postBody.toRequestBody())
                .build()

            var response = client.newCall(request).execute();

            val bytes = response.body?.bytes()
            val string = String(bytes!!)
            val jsonObject = JSONObject(string)
            var obj = jsonObject.getString("Entries")
            ctx.runOnUiThread { onSuccess(obj) }

        }.start()
    }

    fun post(
        url: String,
        load: (res: Response) -> Unit
    ) {
        this.onLoad = load

        Thread {
            val postBody = "".trimMargin()
            var client = OkHttpClient()
            var request = Request.Builder()
                .url(url)
                .post(postBody.toRequestBody())
                .build()

            var response = client.newCall(request).execute();

//            val bytes = response.body?.bytes()
//            val string = String(bytes!!)
//            val jsonObject = JSONObject(string)
//            var obj = jsonObject.getString("Entries")
            ctx.runOnUiThread { onLoad(response) }

        }.start()
    }

    fun mkdirPost(
        success: (result: String) -> Unit,
        fail: (result: String) -> Unit
    ) {
        this.onSuccess = success
        this.onFail = fail

        Thread {
            val postBody = "".trimMargin()
            var client = OkHttpClient()
            var request = Request.Builder()
                .url(url)
                .post(postBody.toRequestBody())
                .build()

            var response = client.newCall(request).execute();

            val bytes = response.body?.bytes()
            val string = String(bytes!!)
            ctx.runOnUiThread { onSuccess(string) }

        }.start()
    }
}