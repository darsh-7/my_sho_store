package com.example.android.shoestore

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.shoestore.databinding.FragmentLoginBinding

class LoginFragmint : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        binding.login.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(LoginFragmintDirections.actionLoginFragmentToWelcomeFragment())
        }

        binding.signup.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(LoginFragmintDirections.actionLoginFragmentToWelcomeFragment())
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i("lout clik", "nave to login")
        when (item.itemId) {
            R.id.new_list ->
                findNavController().navigate(LoginFragmintDirections.actionLoginFragmentToWelcomeFragment())

        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
//                || super.onOptionsItemSelected(item)
//    }
}
