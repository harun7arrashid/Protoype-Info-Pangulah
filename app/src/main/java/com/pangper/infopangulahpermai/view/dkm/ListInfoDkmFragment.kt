package com.pangper.infopangulahpermai.view.dkm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentListInfoDkmBinding


class ListInfoDkmFragment : Fragment() {

    private var _binding: FragmentListInfoDkmBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListInfoDkmBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {
        binding?.btnDkmKotakAmal?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listInfoDkmFragment_to_charityBoxActivity)
        }

        binding?.btnDkmInfaq?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listInfoDkmFragment_to_infaqActivity)
        }

        binding?.btnDkmBangunganMasjid?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listInfoDkmFragment_to_buildingActivity)
        }

        binding?.btnDkmQurban?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listInfoDkmFragment_to_qurbanActivity)
        }

        binding?.btnDkmListrik?.setOnClickListener {
            it.findNavController().navigate(R.id.action_listInfoDkmFragment_to_electricActivity)
        }

        binding?.toolbarInfoDkm?.inflateMenu(R.menu.login_admin_dkm)
        //untuk fungsi click nya
        binding?.toolbarInfoDkm?.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.action_login_dkm -> {
                    findNavController().navigate(R.id.action_listInfoDkmFragment_to_loginAdminDkmFragment)
                    true
                } else -> false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}