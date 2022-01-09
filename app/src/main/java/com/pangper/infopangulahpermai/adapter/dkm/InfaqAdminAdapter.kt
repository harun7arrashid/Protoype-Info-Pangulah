package com.pangper.infopangulahpermai.adapter.dkm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.model.dkm.InfaqModel
import kotlinx.android.synthetic.main.list_item_infaq_admin.view.*

class InfaqAdminAdapter(private val infaq: List<InfaqModel>?, val itemClick: OnItemClickCallback)
    : RecyclerView.Adapter<InfaqAdminAdapter.InfaqAdminViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfaqAdminViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_infaq_admin, parent, false)
        return InfaqAdminViewHolder(view)
    }

    override fun onBindViewHolder(holder: InfaqAdminViewHolder, position: Int) {
        holder.bind(infaq?.get(position))
    }

    override fun getItemCount(): Int = infaq?.size ?: 0

    inner class InfaqAdminViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(infaq: InfaqModel?) {
            with(itemView) {
                tv_list_date_infaq_admin.text    = infaq?.date
                tv_list_nominal_infaq_admin.text = infaq?.nominal

                itemView.setOnClickListener {
                    itemClick.clickDetail(infaq)
                }

                img_list_infaq_edit_admin.setOnClickListener {
                    itemClick.clickEdit(infaq)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun clickDetail(infaq: InfaqModel?)
        fun clickEdit(infaq: InfaqModel?)
    }
}