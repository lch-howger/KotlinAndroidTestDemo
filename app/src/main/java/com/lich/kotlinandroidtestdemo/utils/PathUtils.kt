package com.lich.kotlinandroidtestdemo.utils

import android.Manifest
import android.content.Context
import java.io.File
import java.util.*

/**
 * Created by lichhowger on 2020/11/9.
 */
object PathUtils {

    fun getPath(context: Context): String {
        var fileName = "_file_" + Date().time + ".png"
        val path = context.getExternalFilesDir(null).toString() + fileName
        return path
    }

    fun getPath(context: Context, fileName: String): String {
        val path = context.getExternalFilesDir(null).toString() + fileName
        return path
    }

    fun getFile(context: Context): File {
        val path = getPath(context)
        val file = File(path)
        if (!file.exists()) {
            file.createNewFile()
        }
        return file
    }
}