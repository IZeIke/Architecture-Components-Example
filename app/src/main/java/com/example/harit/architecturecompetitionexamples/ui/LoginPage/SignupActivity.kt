package com.example.harit.architecturecompetitionexamples.ui.LoginPage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.harit.architecturecompetitionexamples.R

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .add(R.id.layoutContainer,SignupFragment.newInstance())
                    .commit()
        }
    }
}