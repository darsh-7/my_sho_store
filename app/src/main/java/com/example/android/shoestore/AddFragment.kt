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

        viewModel.reseShoe()
        binding.myModelView = viewModel
        binding.lifecycleOwner = this


        binding.save.setOnClickListener { view: View ->
            viewModel.saveNewData()
            Log.i("nav to list", binding.name.text.toString() )
            view.findNavController()
                .navigate(AddFragmentDirections.actionGameWonFragmentToGameFragment())
        }




        binding.cancel.setOnClickListener { view: View ->
            Log.i("nav to list", binding.name.text.toString())
            view.findNavController()
                .navigate(AddFragmentDirections.actionGameWonFragmentToGameFragment())
        }


        setHasOptionsMenu(true)
        return binding.root
    }


}


