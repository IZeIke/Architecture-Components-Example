package com.example.harit.architecturecompetitionexamples.ui.FeedPage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.harit.architecturecompetitionexamples.R

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().add(R.id.contentContainer,FeedFragment.newInstance()).commit()
        }
    }

}