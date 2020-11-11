package com.lich.kotlinandroidtestdemo.utils

import com.lich.kotlinandroidtestdemo.entity.UrlEntity

/**
 * Created by lichhowger on 2020/11/11.
 */
object UrlUtils {

    fun getUrl(map: HashMap<String, String>, url: String): String {
        if (map.size > 0) {
            var new = url
            new += "?"
            map.forEach {
                new = new + it.key + "=" + it.value + "&"
            }
            return new
        }
        return url
    }

    fun getUrl(list: MutableList<UrlEntity>, url: String): String {
        if (list.size > 0) {
            var new = url
            new += "?"
            list.forEach {
                new = new + it.key + "=" + it.value + "&"
            }
            return new
        }
        return url
    }
}