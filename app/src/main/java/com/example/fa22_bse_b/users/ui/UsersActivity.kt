package com.example.fa22_bse_b.users.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fa22_bse_b.R
import com.example.fa22_bse_b.databinding.ActivityUsersBinding
import com.example.fa22_bse_b.login_migrated.ui.LoginMigratedActivity
import com.example.fa22_bse_b.prodcuts.adopter.UsersAdopter
import com.example.fa22_bse_b.shared_helper.SharedPreferenceHelper
import com.example.fa22_bse_b.users.vm.LoginForUsersViewModel

class UsersActivity : AppCompatActivity() {
    var binding: ActivityUsersBinding? = null
    val loginViewModel: LoginForUsersViewModel by viewModels()
    var userAdopetr: UsersAdopter? = null
    var sharedPreferenceHelper: SharedPreferenceHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var logedInemail = ""
        if (intent.extras != null) {
            logedInemail = intent.extras?.getString("email") ?: ""
        }
        binding = DataBindingUtil.setContentView(this, R.layout.activity_users)
        userAdopetr = UsersAdopter()
        binding?.usersRv?.adapter = userAdopetr
        binding?.usersRv?.layoutManager = LinearLayoutManager(this)
        sharedPreferenceHelper = SharedPreferenceHelper(this)
        loginViewModel.userList.observe(this) { allLogins ->
            userAdopetr?.submitList(allLogins.map { it.email }.filter { it != logedInemail })
            userAdopetr?.notifyDataSetChanged()
        }



        binding?.backBtn?.setOnClickListener {
            sharedPreferenceHelper?.saveData("No", "IsLoggedIn")
            startActivity(Intent(this, LoginMigratedActivity::class.java))
            finish()
        }

    }
}