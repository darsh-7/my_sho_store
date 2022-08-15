package com.example.android.navigation

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.core.app.ShareCompat
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameWonBinding
import android.content.pm.ResolveInfo
import android.content.pm.PackageManager


class GameWonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false
        )
        binding.save.setOnClickListener { view: View ->
            view.findNavController().navigate(
                GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }


}


