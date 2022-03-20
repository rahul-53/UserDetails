package com.rahul.roomdatabasepractice.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.roomdatabasepractice.R
import com.rahul.roomdatabasepractice.adapter.UserAdapter
import com.rahul.roomdatabasepractice.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_user_list.view.*


class UserListFragment : Fragment() {

    lateinit var userViewModel:UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_user_list, container, false)

        val adapter =UserAdapter()
        val recyclerView = view.listRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager= LinearLayoutManager(requireContext())
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        userViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            user ->adapter.setData(user)
        })

         view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_userListFragment_to_addUserFragment)
        }
        return view
    }
}