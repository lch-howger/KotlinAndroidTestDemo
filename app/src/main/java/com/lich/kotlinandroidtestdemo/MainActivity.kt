package com.lich.kotlinandroidtestdemo

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var toast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT)

    }

    fun test01(view: View) {
        startActivity(Intent(this, TestActivity::class.java))
    }

    fun test02(view: View) {
        startActivity(Intent(this, TestActivity2::class.java))
    }

    fun test03(view: View) {
        startActivity(Intent(this, TestActivity3::class.java))
    }

    fun test04(view: View) {
        startActivity(Intent(this, TestActivity4::class.java))
    }

    fun enterIPFS(view: View) {
        startActivity(Intent(this, IPFSSimpleActivity::class.java))
    }
}


