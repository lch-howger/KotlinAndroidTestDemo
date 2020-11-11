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
        val queue = Volley.newRequestQueue(this)
        val url = "http://18.166.56.133:5001/api/v0/swarm/peers"
        val stringRequest = StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                "Response is: ${response.substring(0, 500)}"
            },
            Response.ErrorListener {
                tv.setText(String(it.networkResponse.data))
            })
        queue.add(stringRequest)
    }

    fun test02(view: View) {
        val queue = Volley.newRequestQueue(this)
        val url = "http://18.166.56.133:5001/api/v0/cat"
        val stringRequest = StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                "Response is: ${response.substring(0, 500)}"
            },
            Response.ErrorListener {
                val string = String(it.networkResponse.data)
                tv.setText(string)
            })
        queue.add(stringRequest)
    }

    fun test03(view: View) {
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

            override fun getHeaders(): MutableMap<String, String> {
                var headers: MutableMap<String, String> = HashMap()
                headers["Content-Type"] = "multipart/form-data"
                return headers
            }

            override fun getParams(): MutableMap<String, String> {
                var map = mutableMapOf<String, String>()
                map.put("ipfs-path", "QmbKfvFbevpfihWwFWjX7xC6rBAhz7oL56wQusyJ9ycuFj")
                return map
            }
        }
        queue.add(stringRequest)
    }

    fun test04(view: View) {
        val queue = Volley.newRequestQueue(this)
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, "http://18.166.56.133:5001/api/v0/cat",
            Response.Listener { response ->
                val response1 = response
                val response2 = response
            },
            Response.ErrorListener {
                var str = String(it.networkResponse.data)
                tv.setText(str)
            }) {
            override fun getHeaders(): MutableMap<String, String> {
                var headers: MutableMap<String, String> = HashMap()
                headers["Content-Type"] = "multipart/form-data"
                return headers
            }

            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["ipfs-path"] = "QmbKfvFbevpfihWwFWjX7xC6rBAhz7oL56wQusyJ9ycuFj"
                return params
            }
        }

        queue.add(stringRequest)
    }

    fun test05(view: View) {
        val queue = Volley.newRequestQueue(this)
        val url = "http://18.166.56.133:5001/api/v0/cat"
        var boundary = "-----------------" + UUID.randomUUID().toString();
        val stringRequest: JsonObjectRequest = object : JsonObjectRequest(
            Method.POST, "http://18.166.56.133:5001/api/v0/cat",null,
            Response.Listener { response ->
                val response1 = response
                val response2 = response
            },
            Response.ErrorListener {
                var str = String(it.networkResponse.data)
                tv.setText(str)
            }) {

            override fun getBodyContentType(): String {
                return "multipart/form-data; boundary=" + boundary;
            }

            override fun getHeaders(): MutableMap<String, String> {
                var headers: MutableMap<String, String> = HashMap()
                headers["Content-Type"] = "multipart/form-data"
                return headers
            }

            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["ipfs-path"] = "QmbKfvFbevpfihWwFWjX7xC6rBAhz7oL56wQusyJ9ycuFj"
                return params
            }

            override fun getBody(): ByteArray {
                val bos = ByteArrayOutputStream()
                val sb = StringBuffer()
                sb.append("Content-Disposition: form-data; name=\"").append("ipfs-path")
                    .append("\"").append("QmbKfvFbevpfihWwFWjX7xC6rBAhz7oL56wQusyJ9ycuFj")
                try {
                    bos.write(sb.toString().toByteArray(charset("utf-8")))
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                return bos.toByteArray()
            }
        }

        queue.add(stringRequest)
    }

    fun test06(view: View) {
        Thread { }.start()
    }

}