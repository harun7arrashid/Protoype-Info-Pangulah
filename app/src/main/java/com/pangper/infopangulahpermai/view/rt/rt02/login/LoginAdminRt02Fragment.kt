package com.pangper.infopangulahpermai.view.rt.rt02.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentLoginAdminRt02Binding


class LoginAdminRt02Fragment : Fragment() {

    private var _binding: FragmentLoginAdminRt02Binding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLoginAdminRt02Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {
        binding?.btnLoginAdminRt02?.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginAdminRt02Fragment_to_infoRt02Activity)
            activity?.finish()
        }
    }
}