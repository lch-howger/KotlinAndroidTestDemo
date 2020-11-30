package com.lich.kotlinandroidtestdemo.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.lich.kotlinandroidtestdemo.adapter.IPFSAdapter
import com.lich.kotlinandroidtestdemo.entity.IPFSEntity
import com.lich.kotlinandroidtestdemo.R
import com.lich.kotlinandroidtestdemo.utils.AppConfig
import com.lich.kotlinandroidtestdemo.utils.HttpUtils
import kotlinx.android.synthetic.main.activity_ipfs.*

/**
 * Created by lichhowger on 2020/11/9.
 */
class IPFSTestActivity : AppCompatActivity() {

    var lastPath: String = "/"
    var nowPath: String = "/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ipfs)

        getData()

    }

    fun newDir(view: View) {
        startActivityForResult(Intent(this, MkdirActivity::class.java), 101)
    }

    fun back(view: View) {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == 200) {
            val dirName = data?.extras?.getString("dirName")
            mkdir(dirName.toString())
        }
    }

    fun mkdir(name: String) {
        HttpUtils(this)
            .simplePost( success = {
                val it1 = it
            }, fail = {

            })
    }

    fun updateUI(links: List<IPFSEntity.Link>) {
        val ipfsAdapter = IPFSAdapter(links)
        lv.adapter = ipfsAdapter
    }

    fun getData() {
        HttpUtils(this)
            .url(AppConfig.API_FILE_LS)
            .add("ipfs-path", "QmNtNpP9joNxS9YATManxT1HoU24RBFXfM9YEnb2ZpzBC5")
            .post(success = {
                val entity = Gson().fromJson(it, IPFSEntity::class.java)
                val links = entity.Links
                updateUI(links)
            }, fail = {

            })


//        Thread {
//            var client = OkHttpClient()
//            var requestBody = MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("ipfs-path", "QmNtNpP9joNxS9YATManxT1HoU24RBFXfM9YEnb2ZpzBC5")
//                .build()
//
//            var request = Request.Builder()
//                .url("http://18.166.56.133:5001/api/v0/file/ls")
//                .post(requestBody)
//                .build()
//
//            var response = client.newCall(request).execute();
//
//            val bytes = response.body?.bytes()
//            try {
//                val string = String(bytes!!)
//                val jsonObject = JSONObject(string)
//                val objects = jsonObject.getJSONObject("Objects")
//                val keys = objects.keys()
//                val next = keys.next()
//                val obj = objects.getJSONObject(next)
//                val entity = Gson().fromJson(obj.toString(), IPFSEntity::class.java)
//                val links = entity.Links
//                runOnUiThread { updateUI(links) }
//
//
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//
//        }.start()
    }
}