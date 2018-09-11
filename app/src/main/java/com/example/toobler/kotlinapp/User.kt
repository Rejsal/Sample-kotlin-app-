package com.example.toobler.kotlinapp

import android.content.Context
import com.example.toobler.kotlinapp.Utils.Pref

/**
 * Created by toobler on 11/9/18.
 */
class User {
    companion object {
        private const val SAMPLE_KEY:String = "SAMPLE_KEY"

        fun setKey(context: Context,key:String){
            Pref.setString(context, SAMPLE_KEY,key)
        }

        fun getKey(context: Context): String {
            return Pref.getString(context, SAMPLE_KEY,"")
        }
    }
}