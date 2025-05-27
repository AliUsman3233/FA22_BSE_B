package com.example.fa22_bse_b.users.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.fa22_bse_b.local_database.room_database.LocalDataBase
import com.example.fa22_bse_b.login_migrated.model.LoginEntity

class LoginForUsersViewModel : ViewModel() {


    val userList: LiveData<List<LoginEntity>> =
        LocalDataBase.getInstance().getLoginDao().getAllLoginsAsFlow().asLiveData()


}