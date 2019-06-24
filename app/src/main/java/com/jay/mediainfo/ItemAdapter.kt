package com.jay.mediainfo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @ProjectName:    TikTok$
 * @Package:        com.jay.mediainfo$
 * @ClassName:      ItemAdapter$
 * @Author:         zhouxu
 * @CreateDate:     2019/6/24$ 14:31$
 * @Version:        1.0
 */

class ItemAdapter(list: List<String>) : RecyclerView.Adapter<ItemAdapter.Holder>(){

    var mDataList: List<String>? = list
    var onItemClick: AdapterView.OnItemClickListener? = null

    fun setOnItemClickListener(onItemClick: AdapterView.OnItemClickListener?) {
        this.onItemClick = onItemClick
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_main_view, null))
    }

    override fun getItemCount(): Int {
        var count = 0
        if (mDataList != null) {
            count = mDataList!!.size
        }
        return count
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.button?.text = mDataList?.get(position)
    }


    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var button: Button? = null

        init {
            button = itemView.findViewById<Button>(R.id.button)
        }
    }
}
