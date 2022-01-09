package com.pangper.infopangulahpermai.view.rt.rt02.citizen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentDetailCitizenRt02Binding


class DetailCitizenRt02Fragment : Fragment() {

    private var _binding: FragmentDetailCitizenRt02Binding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailCitizenRt02Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        binding?.btnDetailBackCitizenRt02?.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailCitizenRt02Fragment_to_citizenInfoRt02Fragment)
        }
    }

    private fun getData() {
        val getData = DetailCitizenRt02FragmentArgs.fromBundle(arguments as Bundle).wargaRt02 // getParcelableExtra
        binding?.tvDetailNameCitizenRt02?.text    = getData?.name
        binding?.tvDetailStatusCitizenRt02?.text  = getData?.status
        binding?.tvDetailAddressCitizenRt02?.text = getData?.address

        when(getData?.gender) {
            "Perempuan" -> Glide.with(activity as Context).load(R.drawable.woman).into(binding?.imgDetailCitizenRt02!!)
            "Laki - laki" -> Glide.with(activity as Context).load(R.drawable.man).into(binding?.imgDetailCitizenRt02!!)
        }
    }
}