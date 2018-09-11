package com.example.toobler.kotlinapp.Utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by toobler on 11/9/18.
 */
class Pref {
    companion object {

        private const val PREF_KEY:String = "PREF_KEY"

        private fun getEditor(context: Context): SharedPreferences.Editor {
            val  preferences = context.getSharedPreferences(PREF_KEY,0)
            return preferences.edit()
        }

        private fun getPreference(context: Context): SharedPreferences {
            return context.getSharedPreferences(PREF_KEY,0)
        }

        //setting and getting boolean value
        fun setBoolean(context: Context,key:String,value:Boolean): Boolean {
            val edit:SharedPreferences.Editor = getEditor(context)
            edit.putBoolean(key,value)
            edit.commit()
            return true
        }

        fun getBoolean(context: Context,key:String,value:Boolean): Boolean{
            return getPreference(context).getBoolean(key,value)
        }

        fun setString(context: Context,key:String,value:String): Boolean {
            val edit:SharedPreferences.Editor = getEditor(context)
            edit.putString(key,value)
            edit.commit()
            return true
        }

        fun getString(context: Context,key:String,value:String): String{
            return getPreference(context).getString(key,value)
        }
    }
}