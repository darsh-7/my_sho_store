package com.example.android.shoestore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListModelView : ViewModel() {
    var newSho = MutableLiveData<MutableList<String>>()
//    val newSho: LiveData<List<String>>
//        get() = _shoList


    init {
        Log.i("ListModelView", "model created")
        newSho.value=mutableListOf()
    }


//    fun saveNewData(n: String, c: String, s: String, d: String) :String {
//        text = text + "\n" + "name" + n +
//                "\nname" + c +
//                "\nname" + s +
//                "\nname" + d
//
//        _shoList.value = text
//        Log.i("saveNewData", _shoList.value.toString())
//        return _shoList.value.toString()
//    }


    override fun onCleared() {
        super.onCleared()
        Log.i("ListModelView", "model destroyed")
    }
}


