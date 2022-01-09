package com.pangper.infopangulahpermai.view.rt.rt03.admin

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
import com.pangper.infopangulahpermai.databinding.FragmentManageCitizenRt03Binding


class ManageCitizenRt03Fragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentManageCitizenRt03Binding? = null
    private val binding get() = _binding
    private var items: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentManageCitizenRt03Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        initListener()
        getSpinner()
    }

    private fun initListener() {

        binding?.btnCitizenCancelRt03?.setOnClickListener {
            it.findNavController().navigate(R.id.action_manageCitizenRt03Fragment_to_manageDataRt03Fragment)
            Toast.makeText(activity, "Dibatalkan", Toast.LENGTH_SHORT).show()
        }

        when(binding?.btnCitizenSaveRt03?.text) {
            "Simpan" -> {
                binding?.btnCitizenSaveRt03?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_manageCitizenRt03Fragment_to_citizenInfoRt03Fragment)
                    Toast.makeText(activity, "Berhasil Disimpan", Toast.LENGTH_SHORT).show()
                }
            }
            "Update" -> {
                binding?.btnCitizenSaveRt03?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_manageCitizenRt03Fragment_to_citizenInfoRt03Fragment)
                    Toast.makeText(activity, "Berhasil DiUpdate", Toast.LENGTH_SHORT).show()
                }
            } else -> {
            binding?.btnCitizenSaveRt03?.setOnClickListener {
                it.findNavController().navigate(R.id.action_manageCitizenRt03Fragment_to_citizenInfoRt03Fragment)
                Toast.makeText(activity, "Gagal Tambah/Edit Data", Toast.LENGTH_SHORT).show()
            }
        }
        }
    }

    private fun getData() {
        val getData = ManageCitizenRt03FragmentArgs.fromBundle(arguments as Bundle).editWargaRt03
        if (getData != null) {
            binding?.edtCitizenFullnameRt03?.setText(getData.name)
            binding?.edtCitizenAddressRt03?.setText(getData.address)

            binding?.tvManageCitizen?.text = "Edit Data Penduduk RT03"
            binding?.btnCitizenSaveRt03?.text = "Update"
        }
    }

    private fun getSpinner() {
        val spinner: Spinner? = binding?.spinnerCitizenRt03
        ArrayAdapter.createFromResource(activity as Context, R.array.warga_tetap, R.layout.spinner_item)
            .also { arrayAdapter ->
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner?.adapter = arrayAdapter
            }
        spinner?.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        items = parent?.getItemAtPosition(position) as String
        Toast.makeText(activity, items, Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(activity, "Tidak ada yg dipilih", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}