package com.lich.kotlinandroidtestdemo.entity

/**
 * Created by lichhowger on 2020/11/9.
 */
class IPFSEntity {
    lateinit var Hash: String
    lateinit var Type: String
    var Size: Int = 0
    lateinit var Links: List<Link>

    class Link {
        lateinit var Name: String
        lateinit var Hash: String
        lateinit var Type: String
        var Size: Int = 0
    }

}