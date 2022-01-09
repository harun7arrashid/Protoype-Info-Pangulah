package com.pangper.infopangulahpermai.view.rt.rt02.login

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentLoginWargaRt02Binding


class LoginWargaRt02Fragment : Fragment() {

    private var _binding: FragmentLoginWargaRt02Binding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLoginWargaRt02Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {
        binding?.btnLoginWargaRt02?.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginWargaRt02Fragment_to_infoRt02Activity)
            activity?.finish()
        }

        binding?.toolbarLoginWargaRt02?.inflateMenu(R.menu.login_rt03_menu)
        // untuk fungsi click nya
        binding?.toolbarLoginWargaRt02?.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.action_login_rt03 -> {
                    findNavController().navigate(R.id.action_loginWargaRt02Fragment_to_loginAdminRt02Fragment)
                    true
                } else -> false
            }
        }

        binding?.tvRegisterWargaRt02?.setOnClickListener { sendWA() }
        binding?.imgWaRt02?.setOnClickListener { sendWA() }
    }

    private fun appInstalledOrNot(url: String): Boolean {
        val packageManager: PackageManager = activity?.packageManager!!
        var appInstalled: Boolean = false
        appInstalled = try {
            packageManager.getPackageInfo(url, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
        return appInstalled
    }

    private fun sendWA() {
        val noHp       = "62812-8122-7459"
        val message    = "Assalmu'alaikum.. Mas Fahrul tolong daftarin saya akun buat aplikasi perum itu dong, Nama :  "
        val installed  = appInstalledOrNot("com.whatsapp")
        if (installed) {
            val intent  = Intent(Intent(Intent.ACTION_VIEW))
            intent.data = Uri.parse("http://api.whatsapp.com/send?phone=${noHp}&text=$message")
            startActivity(intent)
        } else Toast.makeText(activity, "Anda belum menginstall Aplikasi WhatsApp", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}