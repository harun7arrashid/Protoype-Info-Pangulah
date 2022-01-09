package com.pangper.infopangulahpermai.view.rt.rt03.admin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.helper.GalleryHelper
import com.pangper.infopangulahpermai.model.rt.MoneyRt03
import kotlinx.android.synthetic.main.activity_manage_money_rt03.*

class ManageMoneyRt03Activity : AppCompatActivity() {

    private var uriImage: Uri? = null
    private var pickImage = 1

    companion object {
        const val EXTRA_RT03 = "money_Rt03"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_money_rt03)

        getData()
        initListener()
    }

    private fun initListener() {

        btn_manage_money_cancel_rt03.setOnClickListener {
            finish()
            Toast.makeText(this, "Dibatalkan", Toast.LENGTH_SHORT).show()
        }

        img_manage_money_rt03.setOnClickListener {
            if (GalleryHelper.permissionGallery(this, this, pickImage))
                GalleryHelper.openGallery(this)
        }

        when(btn_manage_money_save_rt03.text) {
            "Simpan" -> {
                btn_manage_money_save_rt03.setOnClickListener {
                    finish()
                    Toast.makeText(this, "Berhasil Disimpan", Toast.LENGTH_SHORT).show()
                }
            }
            "Update" -> {
                btn_manage_money_save_rt03.setOnClickListener {
                    finish()
                    Toast.makeText(this, "Berhasil DiUpdate", Toast.LENGTH_SHORT).show()
                }
            } else -> {
            btn_manage_money_save_rt03.setOnClickListener {
                finish()
                Toast.makeText(this, "Gagal Tambah/Edit Data", Toast.LENGTH_SHORT).show()
            }
        }
        }
    }

    private fun getData() {
        val getData = intent.getParcelableExtra<MoneyRt03>(EXTRA_RT03)
        if (getData != null) {
            edt_manage_money_ket_rt03.setText(getData.desc)
            edt_manage_money_nominal_rt03.setText(getData.total)

            Glide.with(this).load(getData.picture ?: R.drawable.img_add_image)
                .into(img_manage_money_rt03)

            btn_manage_money_save_rt03.text = "Update"
            tv_manage_money_title_rt03.text = "Update Data"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickImage && resultCode == Activity.RESULT_OK) {
            uriImage = data?.data
            img_manage_money_rt03.setImageURI(uriImage)
        }
    }
}