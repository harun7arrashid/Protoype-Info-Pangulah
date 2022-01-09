package com.pangper.infopangulahpermai.adapter.dkm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.model.dkm.CharityBox
import kotlinx.android.synthetic.main.list_item_charity_box_admin.view.*

class CharityBoxAdminAdapter(private val amal: List<CharityBox>?, val itemClick: OnItemClickCallback)
    : RecyclerView.Adapter<CharityBoxAdminAdapter.CharityBoxViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharityBoxViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_charity_box_admin, parent, false)
        return CharityBoxViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharityBoxViewHolder, position: Int) {
        holder.bind(amal?.get(position))
    }

    override fun getItemCount(): Int = amal?.size ?: 0

    inner class CharityBoxViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(amal: CharityBox?) {
            with(itemView) {
                tv_list_date_kotakAmal_admin.text    = amal?.date
                tv_list_nominal_kotakAmal_admin.text = amal?.nominal

                itemView.setOnClickListener {
                    itemClick.clickDetail(amal)
                }

                img_list_charityBox_edit_admin.setOnClickListener {
                    itemClick.clickEdit(amal)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun clickDetail(amal: CharityBox?)
        fun clickEdit(amal: CharityBox?)
    }
}