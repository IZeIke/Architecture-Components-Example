package com.example.harit.architecturecompetitionexamples.ui.FeedPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.harit.architecturecompetitionexamples.MyApplication
import com.example.harit.architecturecompetitionexamples.R
import com.example.harit.architecturecompetitionexamples.data.Repository.UserRepository
import com.example.harit.architecturecompetitionexamples.ui.adapter.UserListAdapter
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject


class FeedFragment : Fragment() {

    @Inject
    lateinit var userRepository: UserRepository

    private val viewModel : UserFeedViewModel by lazy {
        ViewModelProviders.of(this).get(UserFeedViewModel::class.java).also {
            MyApplication.appComponent.inject(it)
        }
    }

    companion object {
        fun newInstance() : FeedFragment{
            val view = FeedFragment()
            return view
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApplication.appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(activity).inflate(R.layout.fragment_feed,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userRecyclerView.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)

        viewModel.getAllUser().observe(this, Observer {
            userRecyclerView.adapter = UserListAdapter(it)
            userRecyclerView.adapter?.notifyDataSetChanged()
        })

    }
}