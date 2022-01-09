package com.pangper.infopangulahpermai.view.dkm.qurban

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentDetailQurbanBinding
import com.pangper.infopangulahpermai.view.dkm.infaq.DetailInfaqFragmentArgs


class DetailQurbanFragment : Fragment() {

    private var _binding: FragmentDetailQurbanBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailQurbanBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        binding?.btnDetailBackQurban?.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailQurbanFragment_to_listQurbanFragment)
        }
    }

    private fun getData() {
        val getData = DetailQurbanFragmentArgs.fromBundle(arguments as Bundle).detailQurban
        binding?.tvDetailNameQurban?.text  = getData?.name
        binding?.tvDetailDateQurban?.text  = getData?.date
        binding?.tvDetailJenisQurban?.text = getData?.jenisQurban
        binding?.tvDetailTotalQurban?.text = getData?.nominal
        binding?.tvDetailNamePengQurban?.text = getData?.pengQurban

        Glide.with(activity as Context).load(getData?.picture).into(binding?.imgDetailQurban as ImageView)
    }
}