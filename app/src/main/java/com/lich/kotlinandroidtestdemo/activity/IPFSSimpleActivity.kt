package com.lich.kotlinandroidtestdemo.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lich.kotlinandroidtestdemo.adapter.IPFSSimpleAdapter
import com.lich.kotlinandroidtestdemo.entity.IPFSSimpleEntity
import com.lich.kotlinandroidtestdemo.R
import com.lich.kotlinandroidtestdemo.entity.UrlEntity
import com.lich.kotlinandroidtestdemo.utils.AppConfig
import com.lich.kotlinandroidtestdemo.utils.HttpUtils
import com.lich.kotlinandroidtestdemo.utils.UrlUtils
import kotlinx.android.synthetic.main.activity_ipfs.*

/**
 * Created by lichhowger on 2020/11/9.
 */
class IPFSSimpleActivity : AppCompatActivity() {

    var pathList = mutableListOf<String>()
    var nowPath: String = "/"
    var list = mutableListOf<IPFSSimpleEntity>()
    var adapter: IPFSSimpleAdapter = IPFSSimpleAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ipfs)

        lv.adapter = adapter
        lv.onItemClickListener = AdapterView.OnItemClickListener { p0, p1, i, p3 ->
            val entity = list[i]
            if (entity.Type == 0) {
                enterFile(entity)
            } else if (entity.Type == 1) {
                enterDir(nowPath + entity.Name + "/")
            }
        }

//        lv.onItemLongClickListener =
//            AdapterView.OnItemLongClickListener { adapterView, view, i, l ->
//                val entity = list[i]
//                delete(entity.Name)
//                return@OnItemLongClickListener true
//            }

        pathList.add(nowPath)
        enterDir(pathList[0])
    }

    fun uploadNewFile(view: View) {

    }

    fun delete(name: String) {
        if (name.contains(".")) {
            val list = mutableListOf<UrlEntity>()
            list.add(UrlEntity("arg", "/" + name))
            var url = UrlUtils.getUrl(list, "http://18.166.56.133:5001/api/v0/files/rm")
            HttpUtils(this).post(url, load = {
                if (it.code == 200) {
                    enterDir(nowPath)
                }
            })
        } else {

        }
    }

    fun enterFile(entity: IPFSSimpleEntity) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("name", entity.Name)
        intent.putExtra("hash", entity.Hash)
        intent.putExtra("size", entity.Size)
        startActivity(intent)
    }

    fun enterDir(path: String) {
        var url = AppConfig.API_SIMPLE_LS +  "?long=true"
        val new = UrlUtils.getUrl(url, "arg", path)
        HttpUtils(this)
            .url(new)
            .simplePost(success = {

                if (it.isNullOrEmpty() || it == "null") {
                    list.clear()
                } else {
                    val type = object : TypeToken<List<IPFSSimpleEntity>>() {}.type
                    var data = Gson().fromJson<MutableList<IPFSSimpleEntity>>(it, type)
                    list.clear()
                    list.addAll(data)
                }

                adapter.notifyDataSetChanged()

                nowPath = path
                tv_path.setText("当前路径: " + nowPath)
                if (nowPath != "/") {
                    pathList.add(nowPath)
                }

            }, fail = {

            })
    }

    fun newDir(view: View) {
        startActivityForResult(Intent(this, MkdirActivity::class.java), 101)
    }

    fun back(view: View) {
        if (nowPath == "/") {
            return
        }
        nowPath = nowPath.substring(0, nowPath.length - 1)
        val position = nowPath.lastIndexOf("/")
        nowPath = nowPath.substring(0, position + 1)
        enterDir(nowPath)

//        if (pathList.size <= 1) {
//            return
//        }
//        pathList.removeAt(pathList.size - 1)
//        enterDir(pathList[pathList.size - 1])
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
            .url(AppConfig.API_MKDIR + nowPath + "/" + name)
            .mkdirPost(success = {
                val it1 = it
                enterDir(nowPath)
            }, fail = {

            })
    }

    fun getData() {
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
//                val jsonitect = JSONitect(string)
//                val itects = jsonitect.getJSONitect("itects")
//                val keys = itects.keys()
//                val next = keys.next()
//                val it = itects.getJSONitect(next)
//                val entity = Gson().fromJson(it.toString(), IPFSEntity::class.java)
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