package com.pangper.infopangulahpermai.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.model.rt.CitizenDataRT03
import kotlinx.android.synthetic.main.list_item_citizen_admin.view.*

class CitizenRt03AdminAdapter(private val citizen: List<CitizenDataRT03>?, val itemClick: OnItemClickCallback)
    : RecyclerView.Adapter<CitizenRt03AdminAdapter.CitizenRt03AdminViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitizenRt03AdminViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_citizen_admin, parent, false)
        return CitizenRt03AdminViewHolder(view)
    }

    override fun onBindViewHolder(holder: CitizenRt03AdminViewHolder, position: Int) {
        holder.bind(citizen?.get(position))
    }

    override fun getItemCount(): Int = citizen?.size ?: 0

    inner class CitizenRt03AdminViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(citizen: CitizenDataRT03?) {
            with(itemView) {
                tv_list_citizen_name_admin.text   = citizen?.name
                tv_list_citizen_status_admin.text = citizen?.status

                if (citizen?.gender == "Perempuan") Glide.with(context).load(R.drawable.woman).into(img_list_citizen_admin)
                else Glide.with(context).load(R.drawable.man).into(img_list_citizen_admin)


                when(citizen?.status) {
                    "Warga Tetap" -> tv_list_citizen_status_admin.setTextColor(ContextCompat.getColor(context, R.color.colorHijau))
                    "Warga Tidak Tetap" -> tv_list_citizen_status_admin.setTextColor(ContextCompat.getColor(context, R.color.colorRed))
                }

                itemView.setOnClickListener {
                    itemClick.clickDetail(citizen)
                }

                img_list_citizen_delete_admin.setOnClickListener {
                    itemClick.clickDelete(citizen)
                }

                img_list_citizen_edit_admin.setOnClickListener {
                    itemClick.clickEdit(citizen)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun clickDetail(citizen: CitizenDataRT03?)
        fun clickDelete(citizen: CitizenDataRT03?)
        fun clickEdit(citizen: CitizenDataRT03?)
    }
}