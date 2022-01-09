package com.pangper.infopangulahpermai.view.mainMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentListRtBinding


class ListRtFragment : Fragment() {

    private var _binding: FragmentListRtBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListRtBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding?.btnInfoRt01?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listRtFragment_to_loginRt01Activity)
        }

        binding?.btnInfoRt02?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listRtFragment_to_loginRt02Activity)
        }

        binding?.btnInfoRt03?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listRtFragment_to_loginRt03Activity)
        }

        binding?.btnInfoRt04?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listRtFragment_to_loginRt04Activity)
        }

        binding?.btnInfoDkm?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listRtFragment_to_listInfoDkmFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}