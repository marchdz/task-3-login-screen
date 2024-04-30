package com.marchernandez.basicloginscreentask

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val emailPattern = Patterns.EMAIL_ADDRESS.toRegex()

    private val passwordPattern =
        "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#\$%!])[A-Za-z\\d@#\$%!]{6,}\$".toRegex()

    private val _email = MutableLiveData<String>()
//    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
//    val password: LiveData<String> = _password

    private val _isLoginEnabled = MutableLiveData<Boolean>()
    val isLoginEnabled: LiveData<Boolean> = _isLoginEnabled

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnabled.value = enableLogin(email, password)
    }


    private fun enableLogin(email: String, password: String): Boolean =
        email.matches(emailPattern) && password.matches(passwordPattern)
}