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
//        Log.i("add frag", "called ModelProvider " )
//        val model = ViewModelProvider(this).get(ListModelView::class.java)

        var name: String = binding.name.text.toString()
        var company: String = binding.company.text.toString()
        var size: String = binding.size.text.toString()
        var description: String = binding.description.text.toString()
        //val shoo = arrayOf(name,company,size,description)



        binding.save.setOnClickListener { view: View ->
            Log.i("add frag", "nave to list frag" )
            var sho: String =
                "name :" + name + "\ncompany :" + company + "\nsize :" + size + "\ndescription :" + description

//            model.newSho.value= listOf<String>(sho)
            Log.i("nav to list", binding.name.text.toString() + size + description)
            view.findNavController().navigate(AddFragmentDirections.actionGameWonFragmentToGameFragment(binding.name.text.toString(),binding.company.text.toString(),binding.size.text.toString(),binding.description.text.toString(),true ))
        }
//        binding.cancel.setOnClickListener { view: View ->
//            Log.i("nav to list", binding.name.text.toString() + size + description)
//            view.findNavController().navigate(AddFragmentDirections.actionGameWonFragmentToGameFragment(binding.name.text.toString(),binding.company.text.toString(),binding.size.text.toString(),binding.description.text.toString(),false ))
//        }


        setHasOptionsMenu(true)
        return binding.root
    }


}


