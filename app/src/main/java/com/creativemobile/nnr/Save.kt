package com.creativemobile.nnr

import android.content.Context
import android.content.SharedPreferences
import io.michaelrocks.paranoid.Obfuscate


class Save(var context: Context):SavaStr {

    private var sharedPreferences: SharedPreferences = context.getSharedPreferences(context.packageName,Context.MODE_PRIVATE)


    override var saveStr: String
        get() = sharedPreferences.getString(context.packageName,null)?: ""
        set(value) {
            sharedPreferences.edit().putString(context.packageName,value).apply()
        }
}