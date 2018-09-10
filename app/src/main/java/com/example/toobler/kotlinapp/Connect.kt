package com.example.toobler.kotlinapp

import com.example.toobler.kotlinapp.Constants.Url
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by toobler on 7/9/18.
 */
class Connect {

    companion object {

        private fun getRetrofit(Url:String):Retrofit {
            return Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl(Url)
                    .build()
        }

        fun getApiData():Retrofit{
            val retrofitApi = getRetrofit(Url.BASE_URL)
            return retrofitApi
        }

        fun callApi():CallApi{
            val retrofitCall = getApiData()
            return retrofitCall.create(CallApi::class.java)
        }

    }
}