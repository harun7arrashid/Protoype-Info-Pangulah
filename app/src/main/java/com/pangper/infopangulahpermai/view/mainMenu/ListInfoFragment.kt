package com.pangper.infopangulahpermai.view.mainMenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentListInfoBinding


class ListInfoFragment : Fragment() {

    private var _binding: FragmentListInfoBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListInfoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {

        binding?.btnInfoRw09?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listInfoFragment_to_listRtFragment)
        }

        binding?.btnInfoCulinary?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listInfoFragment_to_culinaryActivity)
        }

        binding?.btnInfoShop?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listInfoFragment_to_shopActivity)
        }

        binding?.btnInfoRental?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listInfoFragment_to_rentalActivity)
        }

        binding?.btnInfoService?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listInfoFragment_to_serviceActivity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}