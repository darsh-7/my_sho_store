package com.example.android.navigation

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
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
    lateinit var vText: TextView
    private val binding2 by lazy {
        FragmentListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false
        )


        binding.newList.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(ListFragmentDirections.actionListFragmentToAddFragment())
        }

        var linerlayout: LinearLayout = binding.listLayout

        val p = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )






        viewModel = ViewModelProvider(this).get(ListModelView::class.java)

        //binding.textView.text = viewModel.newSho.value


        binding.button.setOnClickListener {
            viewModel.newSho.value = "Add new list"
        }

        viewModel.newSho.observe(viewLifecycleOwner, Observer {
            Log.i("model read", "sho changed " + viewModel.newSho)
            //binding.textView.text= it
            val view = layoutInflater.inflate(R.layout.new_field, null)
            viewModel.newShoSave.value = view.textView.text.toString() + "\n" + it
            view.textView.text = viewModel.newShoSave.value

            binding.listLayout.addView(view.textView)

        })

        val args = ListFragmentArgs.fromBundle(arguments!!)
        if (args.valed) {
            Log.i("arg true", "sho changed name: " + args.name)
            var sho: String =
                "name :" + args.name + "\nc" + args.company + "\ns" + args.size + "\nd" + args.description
            viewModel.newSho.value = sho
        }



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

    private fun addShoe(shoeName: String) {
        val view = layoutInflater.inflate(R.layout.new_field, null)
        view.textView.text = shoeName
        binding2.listLayout.addView(view.textView)
    }


}
