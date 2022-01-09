package com.pangper.infopangulahpermai.view.rt.rt03.infort03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentInfoRt03Binding


class InfoRt03Fragment : Fragment() {

    private var _binding: FragmentInfoRt03Binding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentInfoRt03Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {

        binding?.btnInfoWargaRt03?.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoRt03Fragment_to_citizenInfoRt03Fragment)
        }

        binding?.btnInfoKasRt03?.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoRt03Fragment_to_moneyInfoRt03Fragment)
        }

        binding?.btnKelolaDataRt03?.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoRt03Fragment_to_manageDataRt03Fragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}