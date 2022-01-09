package com.pangper.infopangulahpermai.view.rt.rt01.citizen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentDetailCitizenRt01Binding


class DetailCitizenRt01Fragment : Fragment() {

    private var _binding: FragmentDetailCitizenRt01Binding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailCitizenRt01Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        initListener()
    }

    private fun getData() {
        val getData = DetailCitizenRt01FragmentArgs.fromBundle(arguments as Bundle).wargaRt01 // kaya getParcelableExtra
        binding?.tvDetailNameCitizenRt01?.setText(getData?.name)
        binding?.tvDetailStatusCitizenRt01?.setText(getData?.status)
        binding?.tvDetailAddressCitizenRt01?.setText(getData?.address)

        if (getData?.gender == "Perempuan") {
            Glide.with(activity as Context).load(R.drawable.woman).into(binding?.imgDetailCitizenRt01!!)
        } else {
            Glide.with(activity as Context).load(R.drawable.man).into(binding?.imgDetailCitizenRt01!!)
        }
    }

    private fun initListener() {
        binding?.btnDetailBackCitizenRt01?.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailCitizenRt01Fragment_to_citizenInfoRt01Fragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}