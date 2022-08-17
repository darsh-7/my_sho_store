package com.example.android.navigation

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentAddBinding


class AddFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentAddBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add, container, false
        )


        var name: String = binding.name.text.toString()
        var company: String = binding.company.text.toString()
        var size: String = binding.size.text.toString()
        var description: String = binding.description.text.toString()
        //val shoo = arrayOf(name,company,size,description)



        binding.save.setOnClickListener { view: View ->
            view.findNavController().navigate(AddFragmentDirections.actionGameWonFragmentToGameFragment(binding.name.text.toString(),company,binding.company.text.toString(),description,true ))
            Log.i("nav to list", binding.name.text.toString() + size + description)
        }


        setHasOptionsMenu(true)
        return binding.root
    }


}


