package com.example.android.shoestore

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.android.shoestore.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    private val viewModel: ListModelView by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentAddBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add, container, false
        )

        val name = binding.name.text.toString()
        var company = binding.company.text.toString()
        var size: String = binding.size.text.toString()
        var description: String = binding.description.text.toString()



        binding.save.setOnClickListener { view: View ->
            var sho: String =
                "name :" + binding.name.text.toString() + "\ncompany :" + binding.company.text.toString() + "\nsize :" + binding.size.text.toString() + "\ndescription :" + binding.description.text.toString()
            viewModel.newSho.value!! += sho
//            model.newSho.value= listOf<String>(sho)
            Log.i("nav to list", binding.name.text.toString() + size + description)
            view.findNavController()
                .navigate(AddFragmentDirections.actionGameWonFragmentToGameFragment())
        }




        binding.cancel.setOnClickListener { view: View ->
            Log.i("nav to list", binding.name.text.toString() + size + description)
            view.findNavController()
                .navigate(AddFragmentDirections.actionGameWonFragmentToGameFragment())
        }


        setHasOptionsMenu(true)
        return binding.root
    }


}


