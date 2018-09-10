package com.example.toobler.kotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.toobler.kotlinapp.Constants.Key
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloWorld.text = resources.getString(R.string.kotlin_text)

        helloWorld.setOnClickListener { helloWorld.text = Key.txt }

        buttonSubmit.setOnClickListener {
            val  secondActivity = Intent(this,SecondActivity::class.java).apply {
                putExtra("data",Key.txt)
            }
            startActivity(secondActivity)
        }

        RedditData.redditData( object :RedditData.Response{
            override fun reddit(data: Model.Result, status: Boolean) {
                if(status){
                    val items:List<Model.Children> = data.data.children
                    apiText.text = items.get(0).data.author
                    val layout = LinearLayoutManager(this@MainActivity)
                    val adapter = RadditAdapter(items,this@MainActivity)
                    raddit_recycler.layoutManager = layout
                    raddit_recycler.adapter = adapter
                }
            }

        })

    }

    override fun onPause() {
        super.onPause()
        RedditData.disposable?.dispose()
    }

}
