package com.lich.kotlinandroidtestdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.net.HttpURLConnection
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
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "*/*"
    }

    fun test02(view: View) {
        Thread {
            val url = URL("http://18.166.56.133:5001/api/v0/cat")
            val connection = url.openConnection() as HttpURLConnection
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(5 * 60 * 1000);
            connection.setReadTimeout(5 * 60 * 1000);
            //connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");

            connection.addRequestProperty(
                "Content-Type",
                "multipart/form-data; boundary=--testsssssss"
            );
//若需要向服务器请求数据，需要设定为true,默认为false
            connection.setDoOutput(true);
//若提交为post方式，需要修改为false
            connection.setUseCaches(false);
//向报务器连接
            connection.connect();
            var output = connection.getOutputStream();
//向服务器传送post数据
            var bodyStr="ipfs-path=QmbKfvFbevpfihWwFWjX7xC6rBAhz7oL56wQusyJ9ycuFj"
            output.write(bodyStr.toByteArray());
            output.flush()

            var inputStream = connection.inputStream
            val reader = BufferedReader(inputStream.reader())
            val content = StringBuilder()
            try {
                var line = reader.readLine()
                while (line != null) {
                    content.append(line)
                    line = reader.readLine()
                }
            } finally {
                reader.close()
            }
            val toString = content.toString()
            val toString1 = toString
        }.start()
    }

    fun test03(view: View) {
        Thread {
            val url = URL("http://18.166.56.133:5001/api/v0/swarm/peers")
            val connection = url.openConnection() as HttpURLConnection
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(5 * 60 * 1000);
            connection.setReadTimeout(5 * 60 * 1000);
            //connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");

            connection.addRequestProperty(
                "Content-Type",
                "multipart/form-data; boundary=--testsssssss"
            );
//若需要向服务器请求数据，需要设定为true,默认为false
            connection.setDoOutput(true);
//若提交为post方式，需要修改为false
            connection.setUseCaches(false);
//向报务器连接
            connection.connect();
            var output = connection.getOutputStream();
//向服务器传送post数据
            var bodyStr="ipfs-path=QmbKfvFbevpfihWwFWjX7xC6rBAhz7oL56wQusyJ9ycuFj"
            output.write(bodyStr.toByteArray());
            output.flush()

            var inputStream = connection.inputStream
            val reader = BufferedReader(inputStream.reader())
            val content = StringBuilder()
            try {
                var line = reader.readLine()
                while (line != null) {
                    content.append(line)
                    line = reader.readLine()
                }
            } finally {
                reader.close()
            }
            val toString = content.toString()
            val toString1 = toString
        }.start()
    }

    fun test04(view: View) {


        Thread {
            val charset="utf-8"
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
        Thread {  }.start()
    }

    fun test06(view: View) {
        Thread {  }.start()
    }

}