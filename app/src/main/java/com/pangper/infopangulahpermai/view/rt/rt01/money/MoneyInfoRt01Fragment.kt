package com.pangper.infopangulahpermai.view.rt.rt01.money

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
import com.pangper.infopangulahpermai.databinding.FragmentMoneyInfoRt01Binding
import com.pangper.infopangulahpermai.model.rt.MoneyRt03
import com.pangper.infopangulahpermai.view.rt.rt01.admin.ManageMoneyRt01Activity


class MoneyInfoRt01Fragment : Fragment() {

    private var _binding: FragmentMoneyInfoRt01Binding? = null
    private val binding get() = _binding

    private var list: ArrayList<MoneyRt03> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMoneyInfoRt01Binding.inflate(inflater, container, false)
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
        binding?.fabMoneyRt01?.setOnClickListener {
            it.findNavController().navigate(R.id.action_moneyInfoRt01Fragment_to_manageMoneyRt01Activity)
        }
    }

    private fun initView() {

        binding?.rvMoneyRt01?.adapter = MoneyRt03Adapter(list, object : MoneyRt03Adapter.OnItemClickCallback {
            override fun clickDetail(money: MoneyRt03) {
                val intent = MoneyInfoRt01FragmentDirections.actionMoneyInfoRt01FragmentToDetailMoneyRt01Fragment()
                intent.moneyRt01 = money
                findNavController().navigate(intent)
            }

            override fun clickEdit(money: MoneyRt03) {
                val intent = Intent(activity, ManageMoneyRt01Activity::class.java)
                    .putExtra(ManageMoneyRt01Activity.EXTRA_RT01, money)
                startActivity(intent)
            }
        })
        binding?.rvMoneyRt01?.layoutManager = LinearLayoutManager(activity)
        binding?.rvMoneyRt01?.setHasFixedSize(true)
    }

    private fun getData(): List<MoneyRt03> {
        val name   = resources.getStringArray(R.array.pengurus)
        val total  = resources.getStringArray(R.array.total)
        val ket    = resources.getStringArray(R.array.ketMoneyRt)
        val date   = resources.getStringArray(R.array.date)
        val image  = resources.obtainTypedArray(R.array.imageRt)
        val status = resources.getStringArray(R.array.statusMoneyRT)

        val listMoneyRt01 = ArrayList<MoneyRt03>()
        for (i in name.indices) {
            val moneyRt01 = MoneyRt03(
                name[i],
                total[i],
                ket[i],
                date[i],
                image.getResourceId(i, -1),
                status[i]
                )
            listMoneyRt01.add(moneyRt01)
        }
        return listMoneyRt01
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}