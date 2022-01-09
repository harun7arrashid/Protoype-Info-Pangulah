package com.pangper.infopangulahpermai.view.rt.rt02.admin

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
import kotlinx.android.synthetic.main.activity_manage_money_rt02.*

class ManageMoneyRt02Activity : AppCompatActivity() {

    private var uriImage: Uri? = null
    private var pickImage = 1

    companion object {
        const val EXTRA_RT02 = "money_Rt02"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_money_rt02)

        getData()
        initListener()
    }

    private fun initListener() {

        btn_manage_money_cancel_rt02.setOnClickListener {
            finish()
            Toast.makeText(this, "Dibatalkan", Toast.LENGTH_SHORT).show()
        }

        img_manage_money_rt02.setOnClickListener {
            if (GalleryHelper.permissionGallery(this, this, pickImage))
                GalleryHelper.openGallery(this)
        }

        when(btn_manage_money_save_rt02.text) {
            "Simpan" -> {
                btn_manage_money_save_rt02.setOnClickListener {
                    finish()
                    Toast.makeText(this, "Berhasil Disimpan", Toast.LENGTH_SHORT).show()
                }
            }
            "Update" -> {
                btn_manage_money_save_rt02.setOnClickListener {
                    finish()
                    Toast.makeText(this, "Berhasil DiUpdate", Toast.LENGTH_SHORT).show()
                }
            } else -> {
            btn_manage_money_save_rt02.setOnClickListener {
                finish()
                Toast.makeText(this, "Gagal Tambah/Edit Data", Toast.LENGTH_SHORT).show()
            }
        }
        }
    }

    private fun getData() {
        val getData = intent.getParcelableExtra<MoneyRt03>(EXTRA_RT02)
        if (getData != null) {
            edt_manage_money_ket_rt02.setText(getData.desc)
            edt_manage_money_nominal_rt02.setText(getData.total)

            Glide.with(this).load(getData?.picture ?: R.drawable.img_add_image)
                .into(img_manage_money_rt02)

            btn_manage_money_save_rt02.text = "Update"
            tv_manage_money_title_rt02.text = "Update Data"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickImage && resultCode == Activity.RESULT_OK) {
            uriImage = data?.data
            img_manage_money_rt02.setImageURI(uriImage)
        }
    }
}