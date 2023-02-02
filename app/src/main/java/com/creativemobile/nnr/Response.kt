package com.creativemobile.nnr

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import io.michaelrocks.paranoid.Obfuscate
import org.json.JSONObject

class Response {

    fun getStringVolley(callback: VolleyCallback, url: String, context: Context) {
        val strReq = StringRequest(
            Request.Method.GET, url,
            { data ->
                val o = 9
                @Obfuscate
                if (o == 9){

                    val object1 = JSONObject(data)
                    try {
                        val link = object1.get(decod("nkpm_iq",2)).toString()
                        callback.onSuccess(link)
                    } catch (e: Exception) {
                        Log.d("gdk","rww")
                    }
                    try {
                        val msg = object1.get(decod("uouc",2)).toString()
                        callback.onSuccess(msg)
                    } catch (e: Exception) {
                        Log.d("gdk","rww")
                    }
                }

            }) { e -> Log.e("hgf", "dsa") }
        val volley = Volley.newRequestQueue(context)
        volley.add(strReq)
    }

}