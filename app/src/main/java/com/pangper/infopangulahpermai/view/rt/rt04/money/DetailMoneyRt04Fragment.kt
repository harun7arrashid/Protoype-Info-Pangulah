package com.pangper.infopangulahpermai.view.rt.rt04.money

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
import com.pangper.infopangulahpermai.databinding.FragmentDetailMoneyRt04Binding


class DetailMoneyRt04Fragment : Fragment() {

    private var _binding: FragmentDetailMoneyRt04Binding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailMoneyRt04Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        binding?.btnDetailBackRt04?.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailMoneyRt04Fragment_to_moneyInfoRt04Fragment)
        }

    }

    private fun getData() {
        val getData = DetailMoneyRt04FragmentArgs.fromBundle(arguments as Bundle).moneyRt04
        if (getData != null) {
            binding?.tvDetailDateRt04?.text   = getData.date
            binding?.tvDetailKetRt04?.text    = getData.desc
            binding?.tvDetailTotalRt04?.text  = getData.total
            binding?.tvDetailStatusRt04?.text = getData.status
            binding?.tvDetailPengurusRt04?.text  = getData.name

            Glide.with(activity as Context).load(getData.picture).into(binding?.imgDetailMoneyRt04 as ImageView)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}