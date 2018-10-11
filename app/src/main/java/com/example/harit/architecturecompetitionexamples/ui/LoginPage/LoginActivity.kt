package com.example.harit.architecturecompetitionexamples.ui.LoginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.harit.architecturecompetitionexamples.MyApplication
import com.example.harit.architecturecompetitionexamples.R
import com.example.harit.architecturecompetitionexamples.data.Repository.UserRepository
import com.example.harit.architecturecompetitionexamples.ui.FeedPage.FeedActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.appComponent.inject(this)
        initInstance()

    }

    private fun initInstance() {

        loginBtn.setOnClickListener {
            userRepository.getUserFromUsername(usernameEdt.text.toString(),passwordEdt.text.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({user ->
                        startActivity(
                                Intent(this,FeedActivity::class.java)
                        )
                    },{
                      Toast.makeText(this,"username or password mistake",Toast.LENGTH_SHORT).show()
                    })
        }

        registerBtn.setOnClickListener {
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }

    }
}
