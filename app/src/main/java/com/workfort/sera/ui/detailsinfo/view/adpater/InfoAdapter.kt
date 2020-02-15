package com.workfort.sera.ui.detailsinfo.view.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.workfort.sera.databinding.ItemInfoBinding

class InfoAdapter: RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {

    private val mInfoList = arrayListOf<String>()
    private var mCallback: InfoCallback? = null

    fun setInfoList(infoList: ArrayList<String>) {
        mInfoList.clear()
        mInfoList.addAll(infoList)

        notifyItemRangeInserted(0, itemCount)
    }

    fun setCallback(callback: InfoCallback) {
        mCallback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemInfoBinding.inflate(inflater, parent, false)
        return InfoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mInfoList.size
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder.bind(mInfoList[position])
    }

    inner class InfoViewHolder(
        private val binding: ItemInfoBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(info: String) {
            binding.tvInfo.text = info

            binding.container.setOnClickListener {
                mCallback?.onClickInfo(info)
            }
        }
    }

    interface InfoCallback {
        fun onClickInfo(service: String)
    }
}