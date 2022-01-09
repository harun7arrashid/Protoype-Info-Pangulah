package com.pangper.infopangulahpermai.view.rt.rt01.admin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.navigation.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentManageCitizenRt01Binding
import kotlinx.android.synthetic.main.fragment_manage_citizen_rt01.*


class ManageCitizenRt01Fragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentManageCitizenRt01Binding? = null
    private val binding get() = _binding
    private var items: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentManageCitizenRt01Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
        getSpinner()
    }

    private fun initListener() {
        binding?.btnCitizenSaveRt01?.setOnClickListener {
            it.findNavController().navigate(R.id.action_manageCitizenRt01Fragment_to_citizenInfoRt01Fragment)
            it.clearFocus()
            Toast.makeText(activity, "Berhasil Disimpan", Toast.LENGTH_SHORT).show()
        }

        binding?.btnCitizenCancelRt01?.setOnClickListener {
            it.findNavController().navigate(R.id.action_manageCitizenRt01Fragment_to_manageDataRt01Fragment)
            Toast.makeText(activity, "Dibatalkan", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getSpinner() {
        val spinner: Spinner? = binding?.spinnerCitizenRt01
        ArrayAdapter.createFromResource(activity as Context, R.array.warga_tetap, R.layout.spinner_item) // android.R.layout.simple_spinner_item
            .also { arrayAdapter ->
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // untuk menetapkan layout yang harus digunakan adaptor untuk menampilkan daftar pilihan spinner
                spinner?.adapter = arrayAdapter
            }
        spinner?.onItemSelectedListener = this

//        arrayAdapter = ArrayAdapter(activity as Context, android.R.layout.simple_list_item_1, itemList)
//        spinner_citizen_rt01?.adapter = arrayAdapter
//        spinner_citizen_rt01?.onItemSelectedListener = activity as Context
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        items = parent?.getItemAtPosition(position) as String
        Toast.makeText(activity, items, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(activity, "Tidak ada yg dipilih", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}