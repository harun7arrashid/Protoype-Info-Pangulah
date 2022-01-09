package com.pangper.infopangulahpermai.view.dkm.qurban

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.adapter.dkm.QurbanAdminAdapter
import com.pangper.infopangulahpermai.databinding.FragmentListQurbanBinding
import com.pangper.infopangulahpermai.model.dkm.QurbanModel


class ListQurbanFragment : Fragment() {

    private var _binding: FragmentListQurbanBinding? = null
    private val binding get() = _binding
    private var list: ArrayList<QurbanModel> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListQurbanBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.clear()
        list.addAll(getData())
        initView()
    }

    private fun initView() {
        binding?.rvQurban?.adapter = QurbanAdminAdapter(list, object : QurbanAdminAdapter.OnItemClickCallback {
            override fun clickDetail(qurban: QurbanModel?) {
                val intent = ListQurbanFragmentDirections.actionListQurbanFragmentToDetailQurbanFragment()
                intent.detailQurban = qurban
                findNavController().navigate(intent)
            }

            override fun clickEdit(qurban: QurbanModel?) {
                val intent = ListQurbanFragmentDirections.actionListQurbanFragmentToAddQurbanFragment()
                intent.editQurban = qurban
                findNavController().navigate(intent)
            }
        })
        binding?.rvQurban?.layoutManager = LinearLayoutManager(activity)
        binding?.rvQurban?.setHasFixedSize(true)

        binding?.fabQurban?.setOnClickListener {
            val intent = ListQurbanFragmentDirections.actionListQurbanFragmentToAddQurbanFragment()
            findNavController().navigate(intent)
        }
    }

    private fun getData(): List<QurbanModel> {
        val name    = resources.getStringArray(R.array.nameKotakAmal)
        val nominal = resources.getStringArray(R.array.nominalKotakAmal)
        val date    = resources.getStringArray(R.array.dateKotakAmal)
        val image   = resources.obtainTypedArray(R.array.imageKotakAmal)
        val pengQurban = resources.getStringArray(R.array.namePengInfaq)
        val jenisQurban = resources.getStringArray(R.array.jenisQurban)

        val listQurban = ArrayList<QurbanModel>()
        for (i in name.indices) {
            val qurban = QurbanModel(
                name[i],
                nominal[i],
                date[i],
                image.getResourceId(i, -1),
                pengQurban[i],
                jenisQurban[i]
            )
            listQurban.add(qurban)
        }
        return listQurban
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}