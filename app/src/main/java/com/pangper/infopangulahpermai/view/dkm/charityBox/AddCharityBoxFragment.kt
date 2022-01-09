package com.pangper.infopangulahpermai.view.dkm.charityBox

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
import com.pangper.infopangulahpermai.databinding.FragmentAddCharityBoxBinding
import com.pangper.infopangulahpermai.helper.GalleryHelper

class AddCharityBoxFragment : Fragment() {

    private var _binding: FragmentAddCharityBoxBinding? = null
    private val binding get() = _binding
    private var uriImage: Uri? = null
    private var pickImage: Int = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAddCharityBoxBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        initListener()
    }

    private fun getData() {
        val getData = AddCharityBoxFragmentArgs.fromBundle(arguments as Bundle).editCharityBox
        if (getData != null) {
            binding?.edtAddCharityBoxNominal?.setText(getData.nominal)
            Glide.with(activity as Context).load(getData.picture ?: R.drawable.img_add_image)
                .into(binding?.imgAddCharityBox as ImageView)

            binding?.tvAddCharityBoxTitle?.text = "Edit Data"
            binding?.btnAddCharityBoxSave?.text = "Update"
        }
    }

    private fun initListener() {
        binding?.btnAddCharityBoxCancel?.setOnClickListener {
            it.findNavController().navigate(R.id.action_addCharityBoxFragment_to_listCharityBoxFragment)
            Toast.makeText(activity, "Dibatalkan", Toast.LENGTH_SHORT).show()
        }

        binding?.imgAddCharityBox?.setOnClickListener {
            if (GalleryHelper.permissionGallery(activity as Context, activity as Activity, pickImage)) {
                val intent = Intent()
                intent.type = "image/*"
                intent.action = Intent.ACTION_GET_CONTENT
                startActivityForResult(Intent.createChooser(intent, "Pilih Gambar"), pickImage)
            }
        }

        when(binding?.btnAddCharityBoxSave?.text) {
            "Simpan" -> {
                binding?.btnAddCharityBoxSave?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_addCharityBoxFragment_to_listCharityBoxFragment) // Ini kaya Finish...
                    Toast.makeText(activity, "Berhasil Disimpan", Toast.LENGTH_SHORT).show()
                }
            }
            "Update" -> {
                binding?.btnAddCharityBoxSave?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_addCharityBoxFragment_to_listCharityBoxFragment)
                    Toast.makeText(activity, "Berhasil DiUpdate", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
                binding?.btnAddCharityBoxSave?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_addCharityBoxFragment_to_listCharityBoxFragment)
                    Toast.makeText(activity, "Gagal Tambah/Edit Data", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickImage && resultCode == Activity.RESULT_OK) {
            uriImage = data?.data
            binding?.imgAddCharityBox?.setImageURI(uriImage)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}