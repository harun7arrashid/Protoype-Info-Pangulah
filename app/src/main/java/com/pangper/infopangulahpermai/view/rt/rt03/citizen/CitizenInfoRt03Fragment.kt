package com.pangper.infopangulahpermai.view.rt.rt03.citizen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.adapter.CitizenRt03AdminAdapter
import com.pangper.infopangulahpermai.databinding.FragmentCitizenInfoRt03Binding
import com.pangper.infopangulahpermai.model.rt.CitizenDataRT03


class CitizenInfoRt03Fragment : Fragment() {

    private var list: ArrayList<CitizenDataRT03> = arrayListOf()

    private var _binding: FragmentCitizenInfoRt03Binding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCitizenInfoRt03Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.clear()
        list.addAll(getData())
        initView()
        initListener()
    }

    private fun initListener() {
        binding?.fabCitizenRt03?.setOnClickListener {
            val intent = CitizenInfoRt03FragmentDirections.actionCitizenInfoRt03FragmentToManageCitizenRt03Fragment()
            it.findNavController().navigate(intent)
        }
    }

    private fun initView() {
        binding?.rvCitizenRt03?.adapter = CitizenRt03AdminAdapter(list, object : CitizenRt03AdminAdapter.OnItemClickCallback {
            override fun clickDetail(citizen: CitizenDataRT03?) {
                val intent = CitizenInfoRt03FragmentDirections.actionCitizenInfoRt03FragmentToDetailCitizenRt03Fragment()
                intent.wargaRt03 = citizen
                findNavController().navigate(intent)
            }

            override fun clickEdit(citizen: CitizenDataRT03?) {
                val intent = CitizenInfoRt03FragmentDirections.actionCitizenInfoRt03FragmentToManageCitizenRt03Fragment()
                intent.editWargaRt03 = citizen
                findNavController().navigate(intent)
            }

            override fun clickDelete(citizen: CitizenDataRT03?) {
                AlertDialog.Builder(activity as Context).apply {
                    setTitle("Hapus Data!")
                    setMessage("Yakin ingin menghapus ${citizen?.name}")
                    setPositiveButton("HAPUS") { dialog, which ->
                        Toast.makeText(activity, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }
                    setNegativeButton("BATAL") { dialog, which ->
                        dialog.dismiss()
                    }
                }.show()
            }
        })

        binding?.rvCitizenRt03?.layoutManager = LinearLayoutManager(activity)
        binding?.rvCitizenRt03?.setHasFixedSize(true)
    }

    private fun getData(): List<CitizenDataRT03> {
        val name    = resources.getStringArray(R.array.nama_warga)
        val address = resources.getStringArray(R.array.address)
        val gender  = resources.getStringArray(R.array.gender)
        val status  = resources.getStringArray(R.array.status)

        val listWargaRt03 = ArrayList<CitizenDataRT03>()
        for (i in name.indices) {
            val citizenRt03 = CitizenDataRT03(
                name[i],
                address[i],
                gender[i],
                status[i]
            )
            listWargaRt03.add(citizenRt03)
        }
        return listWargaRt03
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}