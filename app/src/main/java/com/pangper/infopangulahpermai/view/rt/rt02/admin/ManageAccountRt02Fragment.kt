package com.pangper.infopangulahpermai.view.rt.rt02.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentManageAccountRt02Binding


class ManageAccountRt02Fragment : Fragment() {

    private var _binding: FragmentManageAccountRt02Binding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentManageAccountRt02Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {
        binding?.btnManageAccountRegisterRt02?.setOnClickListener {
            it.findNavController().navigate(R.id.action_manageAccountRt02Fragment_to_manageDataRt02Fragment)
            Toast.makeText(activity, "Register Berhasil", Toast.LENGTH_LONG).show()
        }

        binding?.btnManageAccountCancelRt02?.setOnClickListener {
            it.findNavController().navigate(R.id.action_manageAccountRt02Fragment_to_manageDataRt02Fragment)
            Toast.makeText(activity, "Dibatalkan", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}