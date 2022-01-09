package com.pangper.infopangulahpermai.adapter.dkm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.model.dkm.BuildingModel
import kotlinx.android.synthetic.main.list_item_building_admin.view.*

class BuildingAdminAdapter(private val build: List<BuildingModel>?, val itemClick: OnItemClickCallback)
    : RecyclerView.Adapter<BuildingAdminAdapter.BuildingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_building_admin, parent, false)
        return BuildingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BuildingViewHolder, position: Int) {
        holder.bind(build?.get(position))
    }

    override fun getItemCount(): Int = build?.size ?: 0

    inner class BuildingViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(build: BuildingModel?) {
            with(itemView) {
                tv_list_date_building_admin.text    = build?.date
                tv_list_nominal_building_admin.text = build?.nominal
                tv_list_status_building_admin.text  = build?.status

                when(build?.status) {
                    "Pemasukan" -> tv_list_status_building_admin.setTextColor(ContextCompat.getColor(context, R.color.colorHijau))
                    "Pengeluaran" -> tv_list_status_building_admin.setTextColor(ContextCompat.getColor(context, R.color.colorRed))
                }

                itemView.setOnClickListener {
                    itemClick.clickDetail(build)
                }

                img_list_building_edit_admin.setOnClickListener {
                    itemClick.clickEdit(build)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun clickDetail(build: BuildingModel?)
        fun clickEdit(build: BuildingModel?)
    }
}