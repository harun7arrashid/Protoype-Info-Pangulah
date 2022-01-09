package com.pangper.infopangulahpermai.view.rt.rt01.money

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
import com.pangper.infopangulahpermai.databinding.FragmentDetailMoneyRt01Binding


class DetailMoneyRt01Fragment : Fragment() {

    private var _binding: FragmentDetailMoneyRt01Binding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailMoneyRt01Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        initListener()
    }

    private fun initListener() {
        binding?.btnDetailBackRt01?.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailMoneyRt01Fragment_to_moneyInfoRt01Fragment)
        }
    }

    private fun getData() {
        val getData = DetailMoneyRt01FragmentArgs.fromBundle(arguments as Bundle).moneyRt01
        if (getData != null) {
            binding?.tvDetailDateRt01?.text   = getData.date
            binding?.tvDetailKetRt01?.text    = getData.desc
            binding?.tvDetailTotalRt01?.text  = getData.total
            binding?.tvDetailStatusRt01?.text = getData.status
            binding?.tvDetailPengurusRt01?.text  = getData.name

            Glide.with(activity as Context).load(getData.picture).into(binding?.imgDetailMoneyRt01 as ImageView)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}