package com.creativemobile.nnr

import com.android.volley.Request
import com.android.volley.RequestQueue

var Requsr:RequestQueue? = null
fun decod(s: String, i: Int): String {
    val cc = "-$i".toInt()
    var string = ""
    for (element in s) {
        var c = element
        if (c in 'a'..'z') {
            c += (cc % 26).toChar().toInt()
            if (c < 'a') c += 26.toChar().toInt()
            if (c > 'z')  c -= 26.toChar().toInt()
        } else if (c in 'A'..'Z') {
            c += (cc % 26).toChar().toInt()
            if (c < 'A') c += 26.toChar().toInt()
            if (c > 'Z') c -= 26.toChar().toInt()
        }
        string += c
    }
    return string
}