package com.pangper.infopangulahpermai.view.dkm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentLoginAdminDkmBinding


class LoginAdminDkmFragment : Fragment() {

    private var _binding: FragmentLoginAdminDkmBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLoginAdminDkmBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnLoginAdminDkm?.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginAdminDkmFragment_to_listInfoDkmFragment)
            Toast.makeText(activity, "Berhasil Login", Toast.LENGTH_SHORT).show()
        }
    }

}