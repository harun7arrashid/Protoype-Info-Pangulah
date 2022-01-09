package com.pangper.infopangulahpermai.view.rt.rt02.money

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
import com.pangper.infopangulahpermai.databinding.FragmentDetailMoneyRt02Binding


class DetailMoneyRt02Fragment : Fragment() {

    private var _binding: FragmentDetailMoneyRt02Binding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailMoneyRt02Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        initListener()
    }

    private fun initListener() {
        binding?.btnDetailBackRt02?.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailMoneyRt02Fragment_to_moneyInfoRt02Fragment)
        }
    }

    private fun getData() {
        val getData = DetailMoneyRt02FragmentArgs.fromBundle(arguments as Bundle).moneyRt02
        if (getData != null) {
            binding?.tvDetailDateRt02?.text   = getData.date
            binding?.tvDetailKetRt02?.text    = getData.desc
            binding?.tvDetailTotalRt02?.text  = getData.total
            binding?.tvDetailStatusRt02?.text = getData.status
            binding?.tvDetailPengurusRt02?.text  = getData.name

            Glide.with(activity as Context).load(getData.picture).into(binding?.imgDetailMoneyRt02 as ImageView)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}