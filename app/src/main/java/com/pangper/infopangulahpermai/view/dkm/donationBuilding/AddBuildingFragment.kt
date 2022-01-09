package com.pangper.infopangulahpermai.view.dkm.donationBuilding

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
import com.pangper.infopangulahpermai.databinding.FragmentAddBuildingBinding
import com.pangper.infopangulahpermai.helper.GalleryHelper


class AddBuildingFragment : Fragment() {

    private var _binding: FragmentAddBuildingBinding? = null
    private val binding get()  = _binding
    private var uriImage: Uri? = null
    private var pickImage: Int = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAddBuildingBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        initListener()
    }

    private fun getData() {
        val getData = AddBuildingFragmentArgs.fromBundle(arguments as Bundle).editBuild
        if (getData != null) {
            binding?.edtAddBuildingNominal?.setText(getData.nominal)
            Glide.with(activity as Context).load(getData.picture ?: R.drawable.img_add_image)
                .into(binding?.imgAddBuilding as ImageView)

            binding?.tvAddBuildingTitle?.text = "Edit Data"
            binding?.btnAddBuildingSave?.text = "Update"
        }
    }

    private fun initListener() {
        binding?.btnAddBuildingCancel?.setOnClickListener {
            it.findNavController().navigate(R.id.action_addBuildingFragment_to_listBuildingFragment)
            Toast.makeText(activity, "Dibatalkan", Toast.LENGTH_SHORT).show()
        }

        binding?.imgAddBuilding?.setOnClickListener {
            if (GalleryHelper.permissionGallery(activity as Context, activity as Activity, pickImage)) {
                val intent = Intent()
                intent.type = "image/*"
                intent.action = Intent.ACTION_GET_CONTENT
                startActivityForResult(Intent.createChooser(intent, "Pilih Gambar"), pickImage)
            }
        }

        when(binding?.btnAddBuildingSave?.text) {
            "Simpan" -> {
                binding?.btnAddBuildingSave?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_addBuildingFragment_to_listBuildingFragment)
                    Toast.makeText(activity, "Berhasil Disimpan", Toast.LENGTH_SHORT).show()
                }
            }
            "Update" -> {
                binding?.btnAddBuildingSave?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_addBuildingFragment_to_listBuildingFragment)
                    Toast.makeText(activity, "Berhasil DiUpdate", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
                binding?.btnAddBuildingSave?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_addBuildingFragment_to_listBuildingFragment)
                    Toast.makeText(activity, "Gagal Tambah/Edit Data", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickImage && resultCode == Activity.RESULT_OK) {
            uriImage = data?.data
            binding?.imgAddBuilding?.setImageURI(uriImage)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}