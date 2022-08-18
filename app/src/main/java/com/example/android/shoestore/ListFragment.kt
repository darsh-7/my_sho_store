package com.example.android.shoestore

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.ListFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.shoestore.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.new_field.view.*

class ListFragment : Fragment() {
    private val viewModel: ListModelView by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding: FragmentListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false
        )

        binding.newList.setOnClickListener { view: View ->
            Log.i("list frag", "nave to addfrag")
            view.findNavController()
                .navigate(ListFragmentDirections.actionListFragmentToAddFragment())
        }



        viewModel.newSho.observe(viewLifecycleOwner, Observer {
            Log.i("model read", "sho changed " + viewModel.newSho)

            for (text in it) {
                val view = layoutInflater.inflate(R.layout.new_field, null)
                view.sho_list.text = text
                binding.listLayout.addView(view)
            }

        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.overflow_menu, menu)
    }


override fun onOptionsItemSelected(item: MenuItem): Boolean {
    Log.i("lout clik","nave to login")
    if(item.itemId==R.id.loggout) {
        viewModel.reseList()
        findNavController().navigate(ListFragmentDirections.actionListFragmentToLoginFragment())
    }
    return super.onOptionsItemSelected(item)
}

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
//                || super.onOptionsItemSelected(item)
//    }

}
