package com.pangper.infopangulahpermai.view.dkm.donationBuilding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.adapter.dkm.BuildingAdminAdapter
import com.pangper.infopangulahpermai.databinding.FragmentListBuildingBinding
import com.pangper.infopangulahpermai.model.dkm.BuildingModel


class ListBuildingFragment : Fragment() {

    private var _binding: FragmentListBuildingBinding? = null
    private val binding get() = _binding
    private var list: ArrayList<BuildingModel> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListBuildingBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.clear()
        list.addAll(getData())
        initView()
    }

    private fun initView() {
        binding?.rvBuilding?.adapter = BuildingAdminAdapter(list, object : BuildingAdminAdapter.OnItemClickCallback {
            override fun clickDetail(build: BuildingModel?) {
                val intent = ListBuildingFragmentDirections.actionListBuildingFragmentToDetailBuildingFragment()
                intent.detailBuild = build
                findNavController().navigate(intent)
            }

            override fun clickEdit(build: BuildingModel?) {
                val intent = ListBuildingFragmentDirections.actionListBuildingFragmentToAddBuildingFragment()
                intent.editBuild = build
                findNavController().navigate(intent)
            }
        })
        binding?.rvBuilding?.layoutManager = LinearLayoutManager(activity)
        binding?.rvBuilding?.setHasFixedSize(true)

        binding?.fabBuilding?.setOnClickListener {
            val intent = ListBuildingFragmentDirections.actionListBuildingFragmentToAddBuildingFragment()
            findNavController().navigate(intent)
        }
    }

    private fun getData(): List<BuildingModel> {
        val name    = resources.getStringArray(R.array.nameKotakAmal)
        val nominal = resources.getStringArray(R.array.nominalKotakAmal)
        val date    = resources.getStringArray(R.array.dateKotakAmal)
        val image   = resources.obtainTypedArray(R.array.imageKotakAmal)
        val status  = resources.getStringArray(R.array.statusBangunan)
        val ket     = resources.getStringArray(R.array.ketBangunan)

        val listBuilding = ArrayList<BuildingModel>()
        for (i in name.indices) {
            val building = BuildingModel(
                name[i],
                nominal[i],
                date[i],
                image.getResourceId(i, -1),
                status[i],
                ket[i]
            )
            listBuilding.add(building)
        }
        return listBuilding
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}