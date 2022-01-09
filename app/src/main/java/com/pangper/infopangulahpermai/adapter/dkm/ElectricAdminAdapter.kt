package com.pangper.infopangulahpermai.adapter.dkm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.model.dkm.ElectricModel
import kotlinx.android.synthetic.main.list_item_electric_admin.view.*

class ElectricAdminAdapter(private val electric: List<ElectricModel>?, val itemClick: OnItemClickCallback)
    : RecyclerView.Adapter<ElectricAdminAdapter.ElectricAdminViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElectricAdminViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_electric_admin, parent, false)
        return ElectricAdminViewHolder(view)
    }

    override fun onBindViewHolder(holder: ElectricAdminViewHolder, position: Int) {
        holder.bind(electric?.get(position))
    }

    override fun getItemCount(): Int = electric?.size ?: 0

    inner class ElectricAdminViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(electric: ElectricModel?) {
            with(itemView) {
                tv_list_date_electric_admin.text = electric?.date
                tv_list_nominal_electric_admin.text = electric?.nominal
                tv_list_status_electric_admin.text = electric?.status

                when(electric?.status) {
                    "Pemasukan" -> tv_list_status_electric_admin.setTextColor(ContextCompat.getColor(context, R.color.colorHijau))
                    "Pengeluaran" -> tv_list_status_electric_admin.setTextColor(ContextCompat.getColor(context, R.color.colorRed))
                }

                itemView.setOnClickListener {
                    itemClick.clickDetail(electric)
                }

                img_list_electric_edit_admin.setOnClickListener {
                    itemClick.clickEdit(electric)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun clickDetail(electric: ElectricModel?)
        fun clickEdit(electric: ElectricModel?)
    }
}