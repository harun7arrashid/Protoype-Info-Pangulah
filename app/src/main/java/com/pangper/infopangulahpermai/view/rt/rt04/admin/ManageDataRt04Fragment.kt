package com.pangper.infopangulahpermai.view.rt.rt04.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentManageDataRt04Binding


class ManageDataRt04Fragment : Fragment() {

    private var _binding: FragmentManageDataRt04Binding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentManageDataRt04Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {
        binding?.btnManageAccountRt04?.setOnClickListener {
            it.findNavController().navigate(R.id.action_manageDataRt04Fragment_to_manageAccountRt04Fragment)
        }

        binding?.btnManageCitizenRt04?.setOnClickListener {
            val intent = ManageDataRt04FragmentDirections.actionManageDataRt04FragmentToManageCitizenRt04Fragment()
            it.findNavController().navigate(intent)
        }

        binding?.btnManageMoneyRt04?.setOnClickListener {
            it.findNavController().navigate(R.id.action_manageDataRt04Fragment_to_manageMoneyRt04Activity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}