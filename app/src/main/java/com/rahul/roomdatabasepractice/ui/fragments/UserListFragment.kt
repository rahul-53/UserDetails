package com.rahul.roomdatabasepractice.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rahul.roomdatabasepractice.R
import kotlinx.android.synthetic.main.fragment_user_list.view.*


class UserListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_user_list, container, false)
         view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_userListFragment_to_addUserFragment)
        }
        return view
    }
}