package com.workfort.sera.ui.main.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.workfort.sera.R
import com.workfort.sera.data.constant.Const
import com.workfort.sera.ui.main.view.adapter.ServiceAdapter
import com.workfort.sera.ui.main.viewmodel.MainViewModel
import com.workfort.sera.ui.mos.view.activity.MosInputActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainViewModel
    private val mServiceAdapter = ServiceAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
        initServiceList()
        observe()
        mViewModel.loadServices()
    }

    private fun observe() {
        mViewModel.mServiceLiveData.observe(this, Observer {
            if(it.isNullOrEmpty()) return@Observer

            mServiceAdapter.setServices(it)
        })
    }

    private fun initServiceList() {
        mServiceAdapter.setCallback(object: ServiceAdapter.ServiceCallback {
            override fun onClickService(service: String) {
                val intent = Intent(this@MainActivity, MosInputActivity::class.java)
                intent.putExtra(Const.Key.SERVICE, service)
                startActivity(intent)
            }
        })

        rv_services.adapter = mServiceAdapter
    }
}
