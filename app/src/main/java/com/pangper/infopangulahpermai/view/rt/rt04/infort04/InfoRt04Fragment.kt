package com.pangper.infopangulahpermai.view.rt.rt04.infort04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentInfoRt04Binding


class InfoRt04Fragment : Fragment() {

    private var _binding: FragmentInfoRt04Binding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentInfoRt04Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding?.btnInfoKasRt04?.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoRt04Fragment_to_moneyInfoRt04Fragment)
        }

        binding?.btnInfoWargaRt04?.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoRt04Fragment_to_citizenInfoRt04Fragment)
        }

        binding?.btnKelolaDataRt04?.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoRt04Fragment_to_manageDataRt04Fragment)
        }
    }
}