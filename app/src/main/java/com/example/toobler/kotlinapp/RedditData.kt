package com.example.toobler.kotlinapp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by toobler on 7/9/18.
 */
class RedditData {
    companion object {
        const val count = 10
        val api by lazy { Connect.callApi() }
        var disposable: Disposable? = null
        fun redditData(callback:Response){
            disposable = api.redditApi(count)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe ({
                        result ->
                        callback.reddit(result,true)
                    }, { error ->
                        error.printStackTrace()
                    })

        }

    }
    interface Response {
        fun reddit(data:Model.Result,status:Boolean)
    }
}