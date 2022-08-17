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
    lateinit var vText: TextView
    private val binding2 by lazy {
        FragmentListBinding.inflate(layoutInflater)
    }
    private var parentLinearLayout: LinearLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(ListModelView::class.java)

        val binding: FragmentListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false
        )

        binding.newList.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(ListFragmentDirections.actionListFragmentToAddFragment())
        }


        val p = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        val args = ListFragmentArgs.fromBundle(arguments!!)




        //binding.textView.text = viewModel.newSho.value


//        binding.button.setOnClickListener {
//            viewModel.newSho.value = "Add new list"
//        }
        if (args.valed) {
            Log.i("arg true", "sho changed name:" )
            var sho: String =
                "name :" + args.name + "\ncompany :" + args.company + "\nsize :" + args.size + "\ndescription :" + args.description

            viewModel.newSho.value= listOf<String>(sho)

            viewModel.newSho.observe(viewLifecycleOwner, Observer {
                Log.i("model read", "sho changed " + viewModel.newSho)
                val view = layoutInflater.inflate(R.layout.new_field, null)
                for (text in it) {
                    view.textView.text = text
                    binding.listLayout.addView(view.textView)
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

    fun onAddField(view: View) {
//        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val rowView: View = inflater.inflate(R.layout.new_field, null)
//        parentLinearLayout!!.addView(rowView, parentLinearLayout!!.childCount - 1)
    }
    private fun addShoe(shoeName: String) {
        val view = layoutInflater.inflate(R.layout.new_field, null)
        view.textView.text = shoeName
        binding2.listLayout.addView(view.textView)
    }


}
