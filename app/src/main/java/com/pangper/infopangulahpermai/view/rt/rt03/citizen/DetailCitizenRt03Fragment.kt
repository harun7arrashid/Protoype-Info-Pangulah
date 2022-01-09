package com.pangper.infopangulahpermai.view.rt.rt03.citizen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentDetailCitizenRt03Binding


class DetailCitizenRt03Fragment : Fragment() {

    private var _binding: FragmentDetailCitizenRt03Binding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailCitizenRt03Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        binding?.btnDetailBackCitizenRt03?.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailCitizenRt03Fragment_to_citizenInfoRt03Fragment)
        }
    }

    private fun getData() {
        val getData = DetailCitizenRt03FragmentArgs.fromBundle(arguments as Bundle).wargaRt03
        binding?.tvDetailNameCitizenRt03?.text    = getData?.name
        binding?.tvDetailAddressCitizenRt03?.text = getData?.address
        binding?.tvDetailStatusCitizenRt03?.text  = getData?.status

        when(getData?.gender) {
            "Perempuan" -> Glide.with(activity as Context).load(R.drawable.woman).into(binding?.imgDetailCitizenRt03!!)
            "Laki - laki" -> Glide.with(activity as Context).load(R.drawable.man).into(binding?.imgDetailCitizenRt03!!)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}