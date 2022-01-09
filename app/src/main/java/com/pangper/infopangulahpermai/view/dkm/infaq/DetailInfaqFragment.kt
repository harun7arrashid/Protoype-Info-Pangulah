package com.pangper.infopangulahpermai.view.dkm.infaq

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentDetailInfaqBinding


class DetailInfaqFragment : Fragment() {

    private var _binding: FragmentDetailInfaqBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailInfaqBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        binding?.btnDetailBackInfaq?.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailInfaqFragment_to_listInfaqFragment)
        }
    }

    private fun getData() {
        val getData = DetailInfaqFragmentArgs.fromBundle(arguments as Bundle).detailInfaq
        binding?.tvDetailNameInfaq?.text  = getData?.name
        binding?.tvDetailDateInfaq?.text  = getData?.date
        binding?.tvDetailTotalInfaq?.text = getData?.nominal
        binding?.tvDetailNamePengInfaq?.text = getData?.penginfaq

        Glide.with(activity as Context).load(getData?.picture).into(binding?.imgDetailInfaq!!)
    }
}