package com.rahul.roomdatabasepractice.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rahul.roomdatabasepractice.R
import com.rahul.roomdatabasepractice.model.User
import com.rahul.roomdatabasepractice.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add_user.*
import kotlinx.android.synthetic.main.fragment_add_user.view.*


class AddUserFragment : Fragment() {

private lateinit var userViewModel:UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_user, container, false)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        view.btnSave.setOnClickListener {
            insertToDatabase()
        }
        return view
    }

    private fun insertToDatabase() {
        val firstName =  etFirstName.text.toString()
        val lastName = etLastName.text.toString()
        val age = etAge.text
        if (inputValidate(firstName, lastName, age)){
            val user = User(0,firstName,lastName, Integer.parseInt(age.toString()))
            userViewModel.addUser(user)
            Toast.makeText(requireContext(), "user added successfully",Toast.LENGTH_SHORT).show()
            //Navigate back
            findNavController().navigate(R.id.action_addUserFragment_to_userListFragment)
        }else{
            Toast.makeText(requireContext(),"Please fill all the fields", Toast.LENGTH_SHORT).show()
        }

    }

    fun inputValidate( firstname:String, lastName:String, age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstname) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}