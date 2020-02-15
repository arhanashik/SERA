package com.workfort.sera.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.workfort.sera.data.constant.Const

class MainViewModel: ViewModel() {

    var mServiceLiveData = MutableLiveData<ArrayList<String>>()

    fun loadServices() {
        mServiceLiveData.postValue(Const.SERVICES)
    }

}