package com.example.toobler.kotlinapp

import com.example.toobler.kotlinapp.Constants.Url
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by toobler on 7/9/18.
 */
interface CallApi {

    @GET(Url.URL)
    fun redditApi(@Query("limit") limit: Int):
            Observable<Model.Result>
}