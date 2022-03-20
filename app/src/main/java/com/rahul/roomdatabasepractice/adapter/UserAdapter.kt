package com.rahul.roomdatabasepractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.rahul.roomdatabasepractice.R
import com.rahul.roomdatabasepractice.model.User
import kotlinx.android.synthetic.main.user_item_layout.view.*


class UserAdapter:RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var userList = emptyList<User>()
    inner class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout,parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentList = userList[position]
        holder.itemView.tvId.text = currentList.id.toString()
        holder.itemView.tvFirstName.text = currentList.firstName.toString()
        holder.itemView.tvLastName.text = currentList.lastName.toString()
        holder.itemView.tvAge.text = currentList.age.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    fun setData(user:List<User>){
        this.userList=user
        notifyDataSetChanged()
    }
}