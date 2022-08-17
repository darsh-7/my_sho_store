package com.example.android.navigation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.new_field.view.*


class ListFragment : Fragment() {
    private lateinit var viewModel: ListModelView
    private val binding2 by lazy {
        FragmentListBinding.inflate(layoutInflater)
    }
    private var parentLinearLayout: LinearLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("list frag", "called ModelProvider " )
        val viewModel = ViewModelProvider(this).get(ListModelView::class.java)


        val binding: FragmentListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false
        )

        binding.newList.setOnClickListener { view: View ->
            Log.i("list frag", "nave to addfrag" )
            view.findNavController()
                .navigate(ListFragmentDirections.actionListFragmentToAddFragment())
        }


        val p = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        val args = ListFragmentArgs.fromBundle(arguments!!)

        if (args.valed) {
            var sho: String =
                "name :" + args.name + "\ncompany :" + args.company + "\nsize :" + args.size + "\ndescription :" + args.description
            viewModel.newSho.value = listOf(sho)
            viewModel.newSho.observe(viewLifecycleOwner, Observer {
                Log.i("model read", "sho changed " + viewModel.newSho)
                val view = layoutInflater.inflate(R.layout.new_field, null)
                for (text in it) {
                    view.sho_list.text = text
                    binding.listLayout.addView(view.sho_list)
                }

            })
        }
//        if (args.valed) {
//            Log.i("arg true", "sho changed name:" )
//            var sho: String =
//                "name :" + args.name + "\ncompany :" + args.company + "\nsize :" + args.size + "\ndescription :" + args.description
//
//            viewModel.newSho.value= listOf<String>(sho)
//        }



        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun addShoe(text: String) {
        val view = layoutInflater.inflate(R.layout.new_field, null)
        view.sho_list.text = text
        binding2.listLayout.addView(view.sho_list)
    }


}
