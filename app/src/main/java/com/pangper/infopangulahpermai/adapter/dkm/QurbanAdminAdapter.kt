package com.pangper.infopangulahpermai.adapter.dkm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.model.dkm.QurbanModel
import kotlinx.android.synthetic.main.list_item_qurban_admin.view.*

class QurbanAdminAdapter(private val qurban: List<QurbanModel>?, val itemClick: OnItemClickCallback)
    : RecyclerView.Adapter<QurbanAdminAdapter.QurbanAdminViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QurbanAdminViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_qurban_admin, parent, false)
        return QurbanAdminViewHolder(view)
    }

    override fun onBindViewHolder(holder: QurbanAdminViewHolder, position: Int) {
        holder.bind(qurban?.get(position))
    }

    override fun getItemCount(): Int = qurban?.size ?: 0

    inner class QurbanAdminViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(qurban: QurbanModel?) {
            with(itemView) {
                tv_list_date_qurban_admin.text    = qurban?.date
                tv_list_nominal_qurban_admin.text = qurban?.nominal
                tv_list_jenis_qurban_admin.text   = qurban?.jenisQurban
                tv_list_name_qurban_admin.text    = "Pa ${qurban?.pengQurban}"

                itemView.setOnClickListener {
                    itemClick.clickDetail(qurban)
                }

                img_list_qurban_edit_admin.setOnClickListener {
                    itemClick.clickEdit(qurban)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun clickDetail(qurban: QurbanModel?)
        fun clickEdit(qurban: QurbanModel?)
    }
}