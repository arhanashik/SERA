package com.workfort.sera.ui.main.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.workfort.sera.databinding.ItemServiceBinding

class ServiceAdapter: RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    private val mServices = arrayListOf<String>()
    private var mCallback: ServiceCallback? = null

    fun setServices(services: ArrayList<String>) {
        mServices.clear()
        mServices.addAll(services)

        notifyItemRangeInserted(0, itemCount)
    }

    fun setCallback(callback: ServiceCallback) {
        mCallback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemServiceBinding.inflate(inflater, parent, false)
        return ServiceViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mServices.size
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(mServices[position])
    }

    inner class ServiceViewHolder(
        private val binding: ItemServiceBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(service: String) {
            binding.tvService.text = service

            binding.container.setOnClickListener {
                mCallback?.onClickService(service)
            }
        }
    }

    interface ServiceCallback {
        fun onClickService(service: String)
    }
}