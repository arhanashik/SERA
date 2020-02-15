package com.workfort.sera.ui.detailsinfo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.workfort.sera.data.constant.Const

class DetailsInfoViewModel: ViewModel() {

    var mInfoListLiveData = MutableLiveData<ArrayList<String>>()

    fun loadInfo() {
        mInfoListLiveData.postValue(Const.TOP_ABILITIES)
    }
}