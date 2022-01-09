package com.pangper.infopangulahpermai.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.model.rt.MoneyRt03
import kotlinx.android.synthetic.main.list_item_money_rt03.view.*

class MoneyRt03Adapter(private val listMoneyRt03: List<MoneyRt03>, val onItemClick: OnItemClickCallback): RecyclerView.Adapter<MoneyRt03Adapter.MoneyRt03Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoneyRt03Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_money_rt03, parent, false)
        return MoneyRt03Holder(view)
    }

    override fun onBindViewHolder(holder: MoneyRt03Holder, position: Int) {
        holder.bind(listMoneyRt03[position])
    }

    override fun getItemCount(): Int = listMoneyRt03.size

    inner class MoneyRt03Holder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(money: MoneyRt03) {
            with(itemView) {
                tv_list_date_rt03.text = money.date
                tv_list_rp_rt03.text   = money.total
                tv_list_status_rt03.text = money.status

                when(money.status) {
                    "Pemasukan" -> tv_list_status_rt03.setTextColor(ContextCompat.getColor(context, R.color.colorHijau))
                    "Pengeluaran" -> tv_list_status_rt03.setTextColor(ContextCompat.getColor(context, R.color.colorRed))
                }

                itemView.setOnClickListener {
                    onItemClick.clickDetail(money)
                }

                img_list_edit_rt03.setOnClickListener {
                    onItemClick.clickEdit(money)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun clickDetail(money: MoneyRt03)
        fun clickEdit(money: MoneyRt03)
    }
}