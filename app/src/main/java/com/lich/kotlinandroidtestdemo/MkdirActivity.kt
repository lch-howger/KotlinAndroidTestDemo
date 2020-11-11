package com.lich.kotlinandroidtestdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mkdir.*

/**
 * Created by lichhowger on 2020/11/10.
 */
class MkdirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mkdir)

    }

    fun confirm(view: View) {
        val dirName = et.text.toString().trim()
        val intent = Intent()
        intent.putExtra("dirName", dirName)
        setResult(200, intent)
        finish()
    }
}