package com.pangper.infopangulahpermai.view.dkm.electricityDonation

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
import com.pangper.infopangulahpermai.databinding.FragmentDetailElectricBinding


class DetailElectricFragment : Fragment() {

    private var _binding: FragmentDetailElectricBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailElectricBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        binding?.btnDetailBackElectric?.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailElectricFragment_to_listElectricFragment)
        }
    }

    private fun getData() {
        val getData = DetailElectricFragmentArgs.fromBundle(arguments as Bundle).detailElectric
        if (getData != null) {
            binding?.tvDetailNameElectric?.text  = getData.pengurus
            binding?.tvDetailDateElectric?.text  = getData.date
            binding?.tvDetailTotalElectric?.text = getData.nominal
            binding?.tvDetailKetElectric?.text   = getData.keterangan
            binding?.tvDetailStatusElectric?.text = getData.status
            binding?.tvDetailPendonasiElectric?.text = getData.pendonasi

            Glide.with(activity as Context).load(getData?.picture).into(binding?.imgDetailElectric as ImageView)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}