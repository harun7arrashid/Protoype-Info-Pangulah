package com.pangper.infopangulahpermai.view.rt.rt04.citizen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentDetailCitizenRt04Binding


class DetailCitizenRt04Fragment : Fragment() {

    private var _binding: FragmentDetailCitizenRt04Binding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailCitizenRt04Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        binding?.btnDetailBackCitizenRt04?.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailCitizenRt04Fragment_to_citizenInfoRt04Fragment)
        }
    }

    private fun getData() {
        val getData = DetailCitizenRt04FragmentArgs.fromBundle(arguments as Bundle).wargaRt04
        binding?.tvDetailNameCitizenRt04?.setText(getData?.name)
        binding?.tvDetailStatusCitizenRt04?.setText(getData?.status)
        binding?.tvDetailAddressCitizenRt04?.setText(getData?.address)

        if (getData?.gender == "Perempuan") {
            Glide.with(activity as Context).load(R.drawable.woman).into(binding?.imgDetailCitizenRt04!!)
        } else Glide.with(activity as Context).load(R.drawable.man).into(binding?.imgDetailCitizenRt04!!)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}