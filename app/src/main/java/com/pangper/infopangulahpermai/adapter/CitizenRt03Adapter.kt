package com.pangper.infopangulahpermai.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.model.rt.CitizenDataRT03
import kotlinx.android.synthetic.main.list_item_citizen.view.*

class CitizenRt03Adapter(private val citizen: List<CitizenDataRT03>?, val itemClick: OnItemClickCallback)
    : RecyclerView.Adapter<CitizenRt03Adapter.CitizenRt03ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitizenRt03ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_citizen, parent, false)
        return CitizenRt03ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CitizenRt03ViewHolder, position: Int) {
        holder.bind(citizen?.get(position))
    }

    override fun getItemCount(): Int = citizen?.size ?: 0

    inner class CitizenRt03ViewHolder(view: View): RecyclerView.ViewHolder(view)  {
        fun bind(citizen: CitizenDataRT03?) {
            with(itemView) {
                tv_list_citizen_name.text = citizen?.name
                tv_list_citizen_status.text = citizen?.status

                if(citizen?.gender == "Perempuan") Glide.with(context).load(R.drawable.woman).into(img_list_citizen)
                else Glide.with(context).load(R.drawable.man).into(img_list_citizen)

                when(citizen?.status) {
                    "Warga Tetap" -> tv_list_citizen_status.setTextColor(ContextCompat.getColor(context, R.color.colorHijau))
                    "Warga Tidak Tetap" -> tv_list_citizen_status.setTextColor(ContextCompat.getColor(context, R.color.colorRed))
                }

                itemView.setOnClickListener {
                    itemClick.onItemClick(citizen)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClick(citizen: CitizenDataRT03?)
    }
}