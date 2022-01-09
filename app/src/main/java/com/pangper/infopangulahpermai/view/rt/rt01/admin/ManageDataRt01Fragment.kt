package com.pangper.infopangulahpermai.view.rt.rt01.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentManageDataRt01Binding


class ManageDataRt01Fragment : Fragment() {

    private var _binding: FragmentManageDataRt01Binding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentManageDataRt01Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {
        binding?.btnManageAccountRt01?.setOnClickListener {
            it.findNavController().navigate(R.id.action_manageDataRt01Fragment_to_manageAccountRt01Fragment)
        }

        binding?.btnManageCitizenRt01?.setOnClickListener {
            it.findNavController().navigate(R.id.action_manageDataRt01Fragment_to_manageCitizenRt01Fragment)
        }

        binding?.btnManageMoneyRt01?.setOnClickListener {
            it.findNavController().navigate(R.id.action_manageDataRt01Fragment_to_manageMoneyRt01Activity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}