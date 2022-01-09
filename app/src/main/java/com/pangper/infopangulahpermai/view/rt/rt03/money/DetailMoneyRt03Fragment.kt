package com.pangper.infopangulahpermai.view.rt.rt03.money

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
import com.pangper.infopangulahpermai.databinding.FragmentDetailMoneyRt03Binding
import com.pangper.infopangulahpermai.view.rt.rt01.money.DetailMoneyRt01FragmentArgs


class DetailMoneyRt03Fragment : Fragment() {

    private var _binding: FragmentDetailMoneyRt03Binding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailMoneyRt03Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        initListener()
    }

    private fun initListener() {
        binding?.btnDetailBackRt03?.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailMoneyRt03Fragment_to_moneyInfoRt03Fragment)
        }
    }

    private fun getData() {
        val getData = DetailMoneyRt03FragmentArgs.fromBundle(arguments as Bundle).moneyRt03
        if (getData != null) {
            binding?.tvDetailDateRt03?.text   = getData.date
            binding?.tvDetailKetRt03?.text    = getData.desc
            binding?.tvDetailTotalRt03?.text  = getData.total
            binding?.tvDetailStatusRt03?.text = getData.status
            binding?.tvDetailPengurusRt03?.text  = getData.name

            Glide.with(activity as Context).load(getData.picture).into(binding?.imgDetailMoneyRt03 as ImageView)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}