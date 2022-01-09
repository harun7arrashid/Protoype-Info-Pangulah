package com.pangper.infopangulahpermai.view.rt.rt03.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentManageDataRt03Binding


class ManageDataRt03Fragment : Fragment() {

    private var _binding: FragmentManageDataRt03Binding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentManageDataRt03Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding?.btnManageAccountRt03?.setOnClickListener {
            it.findNavController().navigate(R.id.action_manageDataRt03Fragment_to_manageAccountRt03Fragment)
        }

        binding?.btnManageCitizenRt03?.setOnClickListener {
            val intent = ManageDataRt03FragmentDirections.actionManageDataRt03FragmentToManageCitizenRt03Fragment()
            findNavController().navigate(intent)
        }

        binding?.btnManageMoneyRt03?.setOnClickListener {
            it.findNavController().navigate(R.id.action_manageDataRt03Fragment_to_manageMoneyRt03Activity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}