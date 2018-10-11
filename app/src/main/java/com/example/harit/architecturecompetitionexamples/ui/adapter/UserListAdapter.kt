package com.example.harit.architecturecompetitionexamples.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.harit.architecturecompetitionexamples.R
import com.example.harit.architecturecompetitionexamples.data.Entity.User
import kotlinx.android.synthetic.main.user_item.view.*

class UserListAdapter(private var usersList : List<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder){
            holder.name.text = usersList.get(position).name
            holder.username.text = usersList.get(position).username
        }
    }

    class ViewHolder(v : View) : RecyclerView.ViewHolder(v) {
        var name = v.name
        var username = v.username
    }
}