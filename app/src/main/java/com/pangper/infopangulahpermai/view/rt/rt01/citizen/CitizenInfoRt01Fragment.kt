package com.pangper.infopangulahpermai.view.rt.rt01.citizen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.adapter.CitizenRt03Adapter
import com.pangper.infopangulahpermai.databinding.FragmentCitizenInfoRt01Binding
import com.pangper.infopangulahpermai.model.rt.CitizenDataRT03


class CitizenInfoRt01Fragment : Fragment() {

    private var _binding: FragmentCitizenInfoRt01Binding? = null
    private val binding get() = _binding

    private var list: ArrayList<CitizenDataRT03> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCitizenInfoRt01Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.clear()
        list.addAll(getData())
        initView()
    }

    private fun initView() {
        binding?.rvCitizenRt01?.adapter = CitizenRt03Adapter(list, object : CitizenRt03Adapter.OnItemClickCallback {
            override fun onItemClick(citizen: CitizenDataRT03?) {
                val intent = CitizenInfoRt01FragmentDirections.actionCitizenInfoRt01FragmentToDetailCitizenRt01Fragment()
                intent.wargaRt01 = citizen // Kaya putExtra
                findNavController().navigate(intent)
            }
        })
        binding?.rvCitizenRt01?.layoutManager = LinearLayoutManager(activity)
        binding?.rvCitizenRt01?.setHasFixedSize(true)
    }

    private fun getData(): List<CitizenDataRT03> {
        val name    = resources.getStringArray(R.array.nama_warga)
        val address = resources.getStringArray(R.array.address)
        val gender  = resources.getStringArray(R.array.gender)
        val status  = resources.getStringArray(R.array.status)

        val listWargaRt01 = ArrayList<CitizenDataRT03>()
        for (i in name.indices) {
            val citizenRt01 = CitizenDataRT03(
                name[i],
                address[i],
                gender[i],
                status[i]
            )
            listWargaRt01.add(citizenRt01)
        }
        return listWargaRt01
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}