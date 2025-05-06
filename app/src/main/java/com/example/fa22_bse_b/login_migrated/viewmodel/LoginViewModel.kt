package com.example.fa22_bse_b.login_migrated.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.fa22_bse_b.login_migrated.model.LoginMigratedModel
import com.example.fa22_bse_b.shared_helper.SharedPreferenceHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val loginModel: LoginMigratedModel = LoginMigratedModel(email = "ali@gmail.com", password = "")
    private var sharedPreferenceHelper: SharedPreferenceHelper? = null


    // LiveData  1-> Mutable LiveData(mutatable), 2-> LiveData(unchanged)

    val loginStateMLD: MutableLiveData<Boolean> = MutableLiveData()
    val signUpStateMLD: MutableLiveData<Boolean> = MutableLiveData()

    //Counter
    val counterStateMLD: MutableLiveData<Int> = MutableLiveData(0)


    val counter2StateLD: LiveData<String> = counterStateMLD.map { counterValue ->
        (counterValue * 2).toString()
    }

    val counter3StateLD: LiveData<String> = counter2StateLD.map {
        (it.toInt()/2).toString()
    }

    init { // Constructor

        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                delay(200)
                counterStateMLD.postValue((counterStateMLD.value ?: 0) + 1)
            }
        }
    }

    fun initSharedPrefHelper(context: Context) {
        sharedPreferenceHelper = SharedPreferenceHelper(context)
    }


    fun onLoginButtonCLick() {
        if (loginModel.email == sharedPreferenceHelper?.getData("email") && loginModel.password == sharedPreferenceHelper?.getData(
                "password"
            )
        ) {
            sharedPreferenceHelper?.saveData("YES", "IsLoggedIn")
            loginStateMLD.value = true

        } else {
            loginStateMLD.value = false
        }
    }

    fun onSignUpButtonClick() {
        signUpStateMLD.value = true
    }

}