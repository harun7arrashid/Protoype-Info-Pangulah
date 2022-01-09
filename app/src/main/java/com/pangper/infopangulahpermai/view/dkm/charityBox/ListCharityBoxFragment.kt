package com.pangper.infopangulahpermai.view.dkm.charityBox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.adapter.dkm.CharityBoxAdminAdapter
import com.pangper.infopangulahpermai.databinding.FragmentListCharityBoxBinding
import com.pangper.infopangulahpermai.model.dkm.CharityBox


class ListCharityBoxFragment : Fragment() {

    private var _binding: FragmentListCharityBoxBinding? = null
    private val binding get() = _binding

    private var list: ArrayList<CharityBox> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListCharityBoxBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.clear()
        list.addAll(getData())
        initView()
    }

    private fun initView() {
        binding?.rvCharityBox?.adapter = CharityBoxAdminAdapter(list, object : CharityBoxAdminAdapter.OnItemClickCallback {
            override fun clickDetail(amal: CharityBox?) {
                val intent = ListCharityBoxFragmentDirections.actionListCharityBoxFragmentToDetailCharityBoxFragment()
                intent.charityBox = amal
                findNavController().navigate(intent)
            }

            override fun clickEdit(amal: CharityBox?) {
                val intent = ListCharityBoxFragmentDirections.actionListCharityBoxFragmentToAddCharityBoxFragment()
                intent.editCharityBox = amal
                findNavController().navigate(intent)
            }
        })
        binding?.rvCharityBox?.layoutManager = LinearLayoutManager(activity)
        binding?.rvCharityBox?.setHasFixedSize(true)

        binding?.fabCharityBox?.setOnClickListener {
            val intent = ListCharityBoxFragmentDirections.actionListCharityBoxFragmentToAddCharityBoxFragment()
            findNavController().navigate(intent)
        }
    }

    private fun getData(): List<CharityBox> {
        val name    = resources.getStringArray(R.array.nameKotakAmal)
        val nominal = resources.getStringArray(R.array.nominalKotakAmal)
        val date    = resources.getStringArray(R.array.dateKotakAmal)
        val image   = resources.obtainTypedArray(R.array.imageKotakAmal)

        val listCharityBox = ArrayList<CharityBox>()
        for (i in name.indices) {
            val charityBox = CharityBox(
                name[i],
                nominal[i],
                date[i],
                image.getResourceId(i, -1)
            )
            listCharityBox.add(charityBox)
        }
        return listCharityBox
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}