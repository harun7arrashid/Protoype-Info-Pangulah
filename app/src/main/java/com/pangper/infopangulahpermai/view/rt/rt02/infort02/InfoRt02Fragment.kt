package com.pangper.infopangulahpermai.view.rt.rt02.infort02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentInfoRt02Binding

class InfoRt02Fragment : Fragment() {

    private var _binding: FragmentInfoRt02Binding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentInfoRt02Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {
        binding?.btnInfoWargaRt02?.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoRt02Fragment_to_citizenInfoRt02Fragment)
        }

        binding?.btnInfoKasRt02?.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoRt02Fragment_to_moneyInfoRt02Fragment)
        }

        binding?.btnKelolaDataRt02?.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoRt02Fragment_to_manageDataRt02Fragment)
        }
    }
}