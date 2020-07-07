package com.sample.rxnaversearchapi.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.sample.rxnaversearchapi.App

class MovieDetailsViewModel : ViewModel() {

    fun request(movieItemUrl: String) {
        Toast.makeText(App.instance.context(), movieItemUrl, Toast.LENGTH_SHORT).show()
    }


}