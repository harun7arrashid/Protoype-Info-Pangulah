package com.pangper.infopangulahpermai.view.dkm.infaq

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
import com.pangper.infopangulahpermai.databinding.FragmentAddInfaqBinding
import com.pangper.infopangulahpermai.helper.GalleryHelper


class AddInfaqFragment : Fragment() {

    private var _binding: FragmentAddInfaqBinding? = null
    private val binding get() = _binding
    private var uriImage: Uri? = null
    private var pickImage: Int = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAddInfaqBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        initListener()
    }

    private fun getData() {
        if (arguments != null) {
            val getData = AddInfaqFragmentArgs.fromBundle(arguments as Bundle).editInfaq
            binding?.edtAddNamePengInfaq?.setText(getData?.penginfaq)
            binding?.edtAddInfaqNominal?.setText(getData?.nominal)
            binding?.imgAddInfaq?.setImageResource(getData?.picture ?: R.drawable.img_add_image)

            binding?.tvAddInfaqTitle?.text = "Edit Data"
            binding?.btnAddInfaqSave?.text = "Update"
        } else Glide.with(activity as Context).load(R.drawable.img_add_image).into(binding?.imgAddInfaq as ImageView)
    }

    private fun initListener() {
        binding?.btnAddInfaqCancel?.setOnClickListener {
            it.findNavController().navigate(R.id.action_addInfaqFragment_to_listInfaqFragment)
            Toast.makeText(activity, "Dibatalkan", Toast.LENGTH_SHORT).show()
        }

        binding?.imgAddInfaq?.setOnClickListener {
            if (GalleryHelper.permissionGallery(activity as Context, activity as Activity, pickImage)) {
                val intent    = Intent()
                intent.type   = "image/*"
                intent.action = Intent.ACTION_GET_CONTENT
                startActivityForResult(Intent.createChooser(intent, "Pilih Gambar"), pickImage)
            }
        }

        when(binding?.btnAddInfaqSave?.text) {
            "Simpan" -> {
                binding?.btnAddInfaqSave?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_addInfaqFragment_to_listInfaqFragment)
                    Toast.makeText(activity, "Berhasil Disimpan", Toast.LENGTH_SHORT).show()
                }
            }
            "Update" -> {
                binding?.btnAddInfaqSave?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_addInfaqFragment_to_listInfaqFragment)
                    Toast.makeText(activity, "Berhasil DiUpdate", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
                binding?.btnAddInfaqSave?.setOnClickListener {
                    it.findNavController().navigate(R.id.action_addInfaqFragment_to_listInfaqFragment)
                    Toast.makeText(activity, "Gagal Update/Tambah Data", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickImage && resultCode == Activity.RESULT_OK) {
            uriImage = data?.data
            binding?.imgAddInfaq?.setImageURI(uriImage)
        }
    }
}