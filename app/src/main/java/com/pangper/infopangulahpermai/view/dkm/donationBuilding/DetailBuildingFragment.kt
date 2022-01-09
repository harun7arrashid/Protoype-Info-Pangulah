package com.pangper.infopangulahpermai.view.dkm.donationBuilding

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
import com.pangper.infopangulahpermai.databinding.FragmentDetailBuildingBinding


class DetailBuildingFragment : Fragment() {

    private var _binding: FragmentDetailBuildingBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailBuildingBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        binding?.btnDetailBackBuilding?.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailBuildingFragment_to_listBuildingFragment)
        }
    }

    private fun getData() {
        val getData = DetailBuildingFragmentArgs.fromBundle(arguments as Bundle).detailBuild
        binding?.tvDetailNameBuilding?.text  = getData?.name
        binding?.tvDetailDateBuilding?.text  = getData?.date
        binding?.tvDetailTotalBuilding?.text = getData?.nominal
        binding?.tvDetailKetBuilding?.text   = getData?.keterangan
        binding?.tvDetailStatusBuilding?.text = getData?.status

        Glide.with(activity as Context).load(getData?.picture).into(binding?.imgDetailBuilding as ImageView)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}