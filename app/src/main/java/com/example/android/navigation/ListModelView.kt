package com.example.android.navigation
import androidx.lifecycle.ViewModel
import android.util.Log

class ListModelView : ViewModel(){
    init {
        Log.i("model","model created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("model","model destro")
    }
}


