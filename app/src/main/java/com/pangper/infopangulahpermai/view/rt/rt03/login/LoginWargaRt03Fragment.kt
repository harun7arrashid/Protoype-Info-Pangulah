package com.pangper.infopangulahpermai.view.rt.rt03.login

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.pangper.infopangulahpermai.R
import com.pangper.infopangulahpermai.databinding.FragmentLoginWargaRt03Binding


class LoginWargaRt03Fragment : Fragment() {

    private var _binding: FragmentLoginWargaRt03Binding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true) //untuk callback action menu di Fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLoginWargaRt03Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListener()
    }

    private fun initListener() {
        binding?.btnLoginWargaRt03?.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginWargaRt03Fragment_to_infoRt03Activity)
            activity?.finish()
        }

        binding?.toolbarLoginWargaRt03?.inflateMenu(R.menu.login_rt03_menu)
        // untuk fungsi click-nya
        binding?.toolbarLoginWargaRt03?.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.action_login_rt03 -> {
                    findNavController().navigate(R.id.action_loginWargaRt03Fragment_to_loginAdminRt03Fragment)
                    true
                } else -> false
            }
        }

        binding?.tvRegisterWargaRt03?.setOnClickListener { sendWA() }
        binding?.imgWaRt03?.setOnClickListener { sendWA() }
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
        val noHp      = "6285218459164"
        val message   = "Assalmu'alaikum.. Om Hery tolong daftarin saya akun buat aplikasi perum itu dong, Nama :  "
        val installed = appInstalledOrNot("com.whatsapp")
        if (installed) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=${noHp}&text=$message"))
            startActivity(intent)
        } else {
            Toast.makeText(activity, "Anda belum menginstall Aplikasi WhatsApp", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}