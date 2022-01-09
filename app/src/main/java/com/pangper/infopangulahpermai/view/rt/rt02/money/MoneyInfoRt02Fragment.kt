package com.pangper.infopangulahpermai.view.rt.rt02.money

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.adapter.MoneyRt03Adapter
import com.pangper.infopangulahpermai.databinding.FragmentMoneyInfoRt02Binding
import com.pangper.infopangulahpermai.model.rt.MoneyRt03
import com.pangper.infopangulahpermai.view.rt.rt02.admin.ManageMoneyRt02Activity

class MoneyInfoRt02Fragment : Fragment() {

    private var _binding: FragmentMoneyInfoRt02Binding? = null
    private val binding get() = _binding

    private var list: ArrayList<MoneyRt03> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMoneyInfoRt02Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        list.clear()
        list.addAll(getData())
        initListener()
    }

    private fun initListener() {
        binding?.fabMoneyRt02?.setOnClickListener {
            it.findNavController().navigate(R.id.action_moneyInfoRt02Fragment_to_manageMoneyRt02Activity)
        }
    }

    private fun initView() {
        binding?.rvMoneyRt02?.adapter = MoneyRt03Adapter(list, object : MoneyRt03Adapter.OnItemClickCallback {
            override fun clickDetail(money: MoneyRt03) {
                val intent = MoneyInfoRt02FragmentDirections.actionMoneyInfoRt02FragmentToDetailMoneyRt02Fragment()
                intent.moneyRt02 = money
                findNavController().navigate(intent)
            }

            override fun clickEdit(money: MoneyRt03) {
                val intent = Intent(activity, ManageMoneyRt02Activity::class.java)
                    .putExtra(ManageMoneyRt02Activity.EXTRA_RT02, money)
                startActivity(intent)
            }
        })
        binding?.rvMoneyRt02?.layoutManager = LinearLayoutManager(activity)
        binding?.rvMoneyRt02?.setHasFixedSize(true)
    }

    private fun getData(): List<MoneyRt03> {
        val name   = resources.getStringArray(R.array.pengurus)
        val total  = resources.getStringArray(R.array.total)
        val ket    = resources.getStringArray(R.array.ketMoneyRt)
        val date   = resources.getStringArray(R.array.date)
        val image  = resources.obtainTypedArray(R.array.imageRt)
        val status = resources.getStringArray(R.array.statusMoneyRT)

        val listMoneyRt02 = ArrayList<MoneyRt03>()
        for (i in name.indices) {
            val moneyRt02 = MoneyRt03(
                name[i],
                total[i],
                ket[i],
                date[i],
                image.getResourceId(i, -1),
                status[i]
            )
            listMoneyRt02.add(moneyRt02)
        }
        return listMoneyRt02
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}