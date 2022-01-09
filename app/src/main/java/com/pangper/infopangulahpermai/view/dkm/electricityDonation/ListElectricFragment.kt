package com.pangper.infopangulahpermai.view.dkm.electricityDonation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.adapter.dkm.ElectricAdminAdapter
import com.pangper.infopangulahpermai.databinding.FragmentListElectricBinding
import com.pangper.infopangulahpermai.model.dkm.ElectricModel

class ListElectricFragment : Fragment() {

    private var _binding: FragmentListElectricBinding? = null
    private val binding get() = _binding
    private var list: ArrayList<ElectricModel> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListElectricBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.clear()
        list.addAll(getData())
        initView()
    }

    private fun initView() {
        binding?.rvElectric?.adapter = ElectricAdminAdapter(list, object : ElectricAdminAdapter.OnItemClickCallback {
            override fun clickDetail(electric: ElectricModel?) {
                val intent = ListElectricFragmentDirections.actionListElectricFragmentToDetailElectricFragment()
                intent.detailElectric = electric
                findNavController().navigate(intent)
            }

            override fun clickEdit(electric: ElectricModel?) {
                val intent = ListElectricFragmentDirections.actionListElectricFragmentToAddElectricFragment()
                intent.editElectric = electric
                findNavController().navigate(intent)
            }
        })
        binding?.rvElectric?.layoutManager = LinearLayoutManager(activity)
        binding?.rvElectric?.setHasFixedSize(true)

        binding?.fabElectric?.setOnClickListener {
            val intent = ListElectricFragmentDirections.actionListElectricFragmentToAddElectricFragment()
            findNavController().navigate(intent)
        }
    }

    private fun getData(): List<ElectricModel> {
        val name    = resources.getStringArray(R.array.nameKotakAmal)
        val nominal = resources.getStringArray(R.array.nominalKotakAmal)
        val date    = resources.getStringArray(R.array.dateKotakAmal)
        val image   = resources.obtainTypedArray(R.array.imageKotakAmal)
        val status  = resources.getStringArray(R.array.statusBangunan)
        val ket     = resources.getStringArray(R.array.ketListrik)
        val pendonasi = resources.getStringArray(R.array.namePengInfaq)

        val listElectric = ArrayList<ElectricModel>()
        for (i in name.indices) {
            val electric = ElectricModel(
                name[i],
                nominal[i],
                date[i],
                image.getResourceId(i, -1),
                status[i],
                ket[i],
                pendonasi[i]
            )
            listElectric.add(electric)
        }
        return listElectric
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}