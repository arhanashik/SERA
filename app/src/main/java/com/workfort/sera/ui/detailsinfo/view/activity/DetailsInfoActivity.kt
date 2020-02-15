package com.workfort.sera.ui.detailsinfo.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.workfort.sera.R
import com.workfort.sera.data.constant.Const
import com.workfort.sera.ui.detailsinfo.view.adpater.InfoAdapter
import com.workfort.sera.ui.detailsinfo.viewmodel.DetailsInfoViewModel
import kotlinx.android.synthetic.main.activity_details_info.*

class DetailsInfoActivity : AppCompatActivity() {

    private var mService: String? = null
    private var mTitle: String? = null

    private lateinit var mViewModel: DetailsInfoViewModel
    private val mInfoAdapter = InfoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_info)

        mService = intent.getStringExtra(Const.Key.SERVICE)
        mTitle = intent.getStringExtra(Const.Key.JOB_TITLE)
        if(mService == null || mTitle == null) return
        title = mService
        tv_title.text = mTitle

        mViewModel = ViewModelProvider.NewInstanceFactory().create(DetailsInfoViewModel::class.java)
        initServiceList()
        observe()
        mViewModel.loadInfo()
    }

    private fun observe() {
        mViewModel.mInfoListLiveData.observe(this, Observer {
            if(it.isNullOrEmpty()) return@Observer

            mInfoAdapter.setInfoList(it)
        })
    }

    private fun initServiceList() {
        mInfoAdapter.setCallback(object: InfoAdapter.InfoCallback {
            override fun onClickInfo(service: String) {

            }
        })

        rv_info_list.adapter = mInfoAdapter
    }
}
