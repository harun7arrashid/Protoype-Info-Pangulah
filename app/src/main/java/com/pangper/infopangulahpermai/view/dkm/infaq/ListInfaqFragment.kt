package com.pangper.infopangulahpermai.view.dkm.infaq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.adapter.dkm.InfaqAdminAdapter
import com.pangper.infopangulahpermai.databinding.FragmentListInfaqBinding
import com.pangper.infopangulahpermai.model.dkm.InfaqModel


class ListInfaqFragment : Fragment() {

    private var _binding: FragmentListInfaqBinding? = null
    private val binding get() = _binding

    private var list: ArrayList<InfaqModel> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListInfaqBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.clear()
        list.addAll(getData())
        initView()
    }

    private fun initView() {
        binding?.rvInfaq?.adapter = InfaqAdminAdapter(list, object : InfaqAdminAdapter.OnItemClickCallback {
            override fun clickDetail(infaq: InfaqModel?) {
                val intent = ListInfaqFragmentDirections.actionListInfaqFragmentToDetailInfaqFragment()
                intent.detailInfaq = infaq
                findNavController().navigate(intent)
            }

            override fun clickEdit(infaq: InfaqModel?) {
                val intent = ListInfaqFragmentDirections.actionListInfaqFragmentToAddInfaqFragment()
                intent.editInfaq = infaq
                findNavController().navigate(intent)
            }
        })
        binding?.rvInfaq?.layoutManager = LinearLayoutManager(activity)
        binding?.rvInfaq?.setHasFixedSize(true)

        binding?.fabInfaq?.setOnClickListener {
            val intent = ListInfaqFragmentDirections.actionListInfaqFragmentToAddInfaqFragment()
            findNavController().navigate(intent)
        }
    }

    private fun getData(): List<InfaqModel> {
        val name    = resources.getStringArray(R.array.nameKotakAmal)
        val nominal = resources.getStringArray(R.array.nominalKotakAmal)
        val date    = resources.getStringArray(R.array.dateKotakAmal)
        val image   = resources.obtainTypedArray(R.array.imageKotakAmal)
        val pengInfaq = resources.getStringArray(R.array.namePengInfaq)

        val listInfaq = ArrayList<InfaqModel>()
        for(i in name.indices) {
            val infaq = InfaqModel(
                name[i],
                nominal[i],
                date[i],
                image.getResourceId(i, -1),
                pengInfaq[i]
            )
            listInfaq.add(infaq)
        }
        return listInfaq
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}