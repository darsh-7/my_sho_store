
package com.example.android.navigation

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_instruction, container, false)


        binding.next.setOnClickListener { view: View ->
            view.findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToListFragment())
        }
        return binding.root
    }
}
