package com.pangper.infopangulahpermai.view.dkm.charityBox

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentDetailCharityBoxBinding


class DetailCharityBoxFragment : Fragment() {

    private var _binding: FragmentDetailCharityBoxBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailCharityBoxBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        binding?.btnDetailBackCharityBox?.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailCharityBoxFragment_to_listCharityBoxFragment)
        }
    }

    private fun getData() {
        val getData = DetailCharityBoxFragmentArgs.fromBundle(arguments as Bundle).charityBox // getParcelable
        binding?.tvDetailNameCharityBox?.text  = getData?.name
        binding?.tvDetailDateCharityBox?.text  = getData?.date
        binding?.tvDetailTotalCharityBox?.text = getData?.nominal

        Glide.with(activity as Context).load(getData?.picture).into(binding?.imgDetailCharityBox!!)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}