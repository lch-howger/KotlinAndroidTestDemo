package com.lich.kotlinandroidtestdemo.activity

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.lich.kotlinandroidtestdemo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var toast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT)

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun test01(view: View) {
        val intent = Intent(this, StarActivity::class.java)
        startActivity(
            intent,
            ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
        )
    }

    fun test02(view: View) {
        startActivity(Intent(this, TestActivity2::class.java))
        overridePendingTransition(R.anim.anim_activity_out, R.anim.anim_activity_in)
    }

    fun test03(view: View) {
        startActivity(Intent(this, TestActivity3::class.java))
    }

    fun test04(view: View) {
        startActivity(Intent(this, TestActivity4::class.java))
    }

//    fun test02(view: View) {
//        startActivity(Intent(this, TestActivity2::class.java))
//    }
//
//    fun test03(view: View) {
//        startActivity(Intent(this, TestActivity3::class.java))
//    }
//
//    fun test04(view: View) {
//        startActivity(Intent(this, TestActivity4::class.java))
//    }
//
//    fun enterIPFS(view: View) {
//        startActivity(Intent(this, IPFSSimpleActivity::class.java))
//    }
}


