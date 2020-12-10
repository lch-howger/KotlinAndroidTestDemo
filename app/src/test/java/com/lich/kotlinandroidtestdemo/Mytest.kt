package com.lich.kotlinandroidtestdemo

import android.util.Base64
import net.i2p.crypto.eddsa.KeyPairGenerator
import org.junit.Test

import org.junit.Assert.*
import java.security.SecureRandom

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Mytest {

    @Test
    fun test() {
        val generator = KeyPairGenerator()
        generator.initialize(256, SecureRandom())
        val pair=generator.generateKeyPair()

        val pri = pair.private.encoded
        val pub = pair.public.encoded

        val priString = Base64.encodeToString(pri, Base64.DEFAULT)
        val pubString = Base64.encodeToString(pub, Base64.DEFAULT)

        println(priString)
        println(pubString)

        var str = "helloworldhelloworldhelloworld12"
        val bytes = str.toByteArray()
        bytes.forEach {
            print(""+it+",")
        }
    }
}