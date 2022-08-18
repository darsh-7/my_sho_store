package com.example.android.shoestore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListModelView : ViewModel() {
    var newSho = MutableLiveData<MutableList<String>>()

    var name = ""
    var size = ""
    var company = ""
    var description = ""


    init {
        Log.i("ListModelView", "model created")
        newSho.value=mutableListOf()
    }

    fun reseList() {
       newSho.value?.clear()
    }

    fun reseShoe() {
        name = ""
        size = ""
        company = ""
        description = ""
    }

    fun saveNewData() {
        var sho: String = "name :" + name + "\ncompany :" + company + "\nsize :" + size + "\ndescription :" +description

        newSho.value!! += sho
        Log.i("ListModelView","saveNewData"+ sho)
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("ListModelView", "model destroyed")
    }
}


