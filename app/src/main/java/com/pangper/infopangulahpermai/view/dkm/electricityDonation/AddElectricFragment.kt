package com.pangper.infopangulahpermai.view.dkm.electricityDonation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentAddElectricBinding
import com.pangper.infopangulahpermai.helper.GalleryHelper


class AddElectricFragment : Fragment() {

    private var _binding: FragmentAddElectricBinding? = null
    private val binding get()  = _binding
    private var uriImage: Uri? = null
    private var pickImage: Int = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAddElectricBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        initListener()
    }

    private fun getData() {
        val getData = AddElectricFragmentArgs.fromBundle(arguments as Bundle).editElectric
        if (getData != null) {
            binding?.edtAddElectricKet?.setText(getData.keterangan)
            binding?.edtAddElectricNominal?.setText(getData.nominal)
            binding?.edtAddElectricPendonasi?.setText(getData.pendonasi)

            Glide.with(activity as Context).load(getData.picture ?: R.drawable.img_add_image)
                .into(binding?.imgAddElectric as ImageView)

            binding?.toolbarAddElectric?.title = "Update Donasi Listrik"
            binding?.btnAddElectricSave?.text = "Update"
        }
    }
    
    private fun initListener() {
        binding?.btnAddElectricCancel?.setOnClickListener {
            it.findNavController().navigate(R.id.action_addElectricFragment_to_listElectricFragment)
            Toast.makeText(activity, "Dibatalkan", Toast.LENGTH_SHORT).show()
        }
        
        binding?.imgAddElectric?.setOnClickListener { 
            if (GalleryHelper.permissionGallery(activity as Context, activity as Activity, pickImage)) {
                val intent = Intent()
                intent.type = "image/*"
                intent.action = Intent.ACTION_GET_CONTENT
                startActivityForResult(Intent.createChooser(intent, "Pilih Gambar"), pickImage)
            }
        }

        when(binding?.btnAddElectricSave?.text) {
            "Simpan" -> {
                binding?.btnAddElectricSave?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_addElectricFragment_to_listElectricFragment)
                    Toast.makeText(activity, "Berhasil Disimpan", Toast.LENGTH_SHORT).show()
                }
            }
            "Update" -> {
                binding?.btnAddElectricSave?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_addElectricFragment_to_listElectricFragment)
                    Toast.makeText(activity, "Berhasil DiUpdate", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
                binding?.btnAddElectricSave?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_addElectricFragment_to_listElectricFragment)
                    Toast.makeText(activity, "Gagal Tambah/Edit Data", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickImage && resultCode == Activity.RESULT_OK) {
            uriImage = data?.data
            binding?.imgAddElectric?.setImageURI(uriImage)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}