package com.example.toobler.kotlinapp

/**
 * Created by toobler on 7/9/18.
 */
object Model {
    data class Result(val data: Data)
    data class Data(val children: List<Children>)
    data class Children(val data: Datas)
    data class Datas(val author: String,val thumbnail: String,val title: String)
}