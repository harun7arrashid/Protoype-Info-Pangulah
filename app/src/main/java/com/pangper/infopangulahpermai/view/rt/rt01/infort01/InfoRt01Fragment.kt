package com.pangper.infopangulahpermai.view.rt.rt01.infort01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentInfoRt01Binding

class InfoRt01Fragment : Fragment() {

    private var _binding: FragmentInfoRt01Binding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentInfoRt01Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {
        binding?.btnInfoWargaRt01?.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoRt01Fragment_to_citizenInfoRt01Fragment)
        }

        binding?.btnInfoKasRt01?.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoRt01Fragment_to_moneyInfoRt01Fragment)
        }

        binding?.btnKelolaDataRt01?.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoRt01Fragment_to_manageDataRt01Fragment)

        }
    }
}