package com.pangper.infopangulahpermai.view.rt.rt03.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.pangper.infopangulahpermai.R

class LoginRt03Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_rt03)

      //  supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

//    override fun onSupportNavigateUp(): Boolean {
//       // return super.onSupportNavigateUp()
//        //return findNavController(R.id.my_nav_host_fragment).navigateUp(appBarConfiguration)
//        return findNavController(R.id.login_rt03_navigation).navigateUp()
//    }
//
//    // override fun onOptionsItemSelected(item: MenuItem): Boolean {
//    //    return item.onNavDestinationSelected(findNavController(R.id.my_nav_host_fragment))
//    //            || super.onOptionsItemSelected(item)
//    //}
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return item.onNavDestinationSelected(findNavController(R.id.login_rt03_navigation))
//                || super.onOptionsItemSelected(item)
//    }
}