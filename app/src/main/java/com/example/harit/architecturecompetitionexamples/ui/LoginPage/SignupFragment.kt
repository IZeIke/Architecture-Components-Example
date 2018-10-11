package com.example.harit.architecturecompetitionexamples.ui.LoginPage

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.harit.architecturecompetitionexamples.MyApplication
import com.example.harit.architecturecompetitionexamples.R
import com.example.harit.architecturecompetitionexamples.data.Entity.User
import com.example.harit.architecturecompetitionexamples.data.Repository.UserRepository
import com.example.harit.architecturecompetitionexamples.data.local.AppDatabase
import com.example.harit.architecturecompetitionexamples.extension.checkName
import com.example.harit.architecturecompetitionexamples.extension.checkPassword
import com.example.harit.architecturecompetitionexamples.extension.checkUsername
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_sign_up.*
import java.util.*
import javax.inject.Inject

class SignupFragment : Fragment() {

    @Inject
    lateinit var userRepository: UserRepository

    companion object {
        fun newInstance() : Fragment{
            val fragment = SignupFragment()
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApplication.appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_sign_up,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signupBtn.setOnClickListener {
            val user = User()
            user.id = UUID.randomUUID().toString()
            user.name = if(nameEdt.text.toString().checkName()) nameEdt.text.toString() else {
                nameWarning.text = "Name can't contain special letter"
                ""
            }
            user.password = if (passwordEdt.text.toString().checkPassword()) passwordEdt.text.toString() else {
                passwordWarning.text = "Password must contain more than 8 character"
                ""
            }
            user.username = if (usernameEdt.text.toString().checkUsername()) usernameEdt.text.toString() else {
                usernameWarning.text = "Username must contain more than 6 character"
                ""
            }

            if(user.name.checkName()
                    && user.password.checkPassword()
                    && user.username.checkUsername()){

                Observable.fromCallable { userRepository.insert(user) }
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe {
                            Toast.makeText(activity,"insert complete",Toast.LENGTH_SHORT).show()
                        }
            }
        }

    }
}