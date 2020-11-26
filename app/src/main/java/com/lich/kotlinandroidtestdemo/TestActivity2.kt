package com.lich.kotlinandroidtestdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.lich.kotlinandroidtestdemo.entity.UrlEntity
import com.lich.kotlinandroidtestdemo.utils.FileUtils
import com.lich.kotlinandroidtestdemo.utils.UrlUtils
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.*
import java.net.URL


/**
 * Created by lichhowger on 2020/11/9.
 */
class TestActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }

    fun test01(view: View) {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        startActivityForResult(intent, 101)
    }

    fun test02(view: View) {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.type = "*/*"
        startActivityForResult(intent, 102)
    }

    fun test03(view: View) {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "*/*"
        startActivityForResult(intent, 103)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null && requestCode == 101) {
            val uri = data.data
            val file = FileUtils.getFilePathByUri(this, uri)
            uploadFile(file)
        }
    }

    fun uploadFile(path: String) {
        Thread {
            var file = File(path)
            var fileName = file.name
            val fileBody = file.asRequestBody("multipart/form-data".toMediaTypeOrNull())

            var client = OkHttpClient()
            var requestBody = MultipartBody.Builder().setType(MultipartBody.FORM)
            requestBody.addFormDataPart("file", fileName, fileBody)
            var body = requestBody.build()

            var request = Request.Builder()
                .url("http://18.166.56.133:5001/api/v0/add")
                .post(body)
                .build()

            var response = client.newCall(request).execute();

            val bytes = response.body?.bytes()
            val string = String(bytes!!)
            val entity = Gson().fromJson(string, IPFSAddEntity::class.java)
            copyFile(entity)
        }.start()
    }

    fun copyFile(entity: IPFSAddEntity) {
        Thread {
            var list = mutableListOf<UrlEntity>()
            list.add(UrlEntity("arg", "/ipfs/" + entity.Hash))
            list.add(UrlEntity("arg", "/" + entity.Name))
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
                println("a")
            } else if (response.code == 500) {
                println("a")
            }

        }.start()
    }

    fun test04(view: View) {
        Thread {
            val charset = "utf-8"
            val bufferResult = StringBuffer()
            val conn = URL("http://18.166.56.133:5001/api/v0/cat").openConnection()
            conn.setRequestProperty("accept", "*/*")
            conn.setRequestProperty("connection", "Keep-Alive")
            conn.setRequestProperty(
                "user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)"
            )
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true)
            conn.setDoInput(true)

            val out = PrintWriter(OutputStreamWriter(conn.outputStream, charset))
            //发送请求
            out.print("ipfs-path=QmbKfvFbevpfihWwFWjX7xC6rBAhz7oL56wQusyJ9ycuFj")
            //flush 输出流缓冲
            out.flush()
            val inStream = BufferedReader(InputStreamReader(conn.inputStream, charset))
            inStream.use { r ->
                val temp = r.readLine()
                if (temp != null) bufferResult.append(temp)
            }
            out.close()
            inStream.close()

            val toString = bufferResult.toString()
            val toString1 = toString

        }.start()
    }

    fun test05(view: View) {
        Thread { }.start()
    }

    fun test06(view: View) {
        Thread { }.start()
    }

}