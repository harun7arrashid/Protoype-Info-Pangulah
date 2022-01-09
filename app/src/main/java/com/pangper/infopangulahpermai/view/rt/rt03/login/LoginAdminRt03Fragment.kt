package com.pangper.infopangulahpermai.view.rt.rt03.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentLoginAdminRt03Binding

class LoginAdminRt03Fragment : Fragment() {

    private var _binding: FragmentLoginAdminRt03Binding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true) // memberi tahu bahwa fragment ingin menerima callback terkait menu
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLoginAdminRt03Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {
        binding?.btnLoginAdminRt03?.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginAdminRt03Fragment_to_infoRt03Activity)
            activity?.finish()
        }
    }

}