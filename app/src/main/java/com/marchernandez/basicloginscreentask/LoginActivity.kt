package com.marchernandez.basicloginscreentask

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.marchernandez.basicloginscreentask.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by lazy { ViewModelProvider(this)[LoginViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                loginViewModel.onLoginChanged(
                    email = binding.etEmail.text.toString(),
                    password = binding.etPassword.text.toString()
                )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                loginViewModel.onLoginChanged(
                    email = binding.etEmail.text.toString(),
                    password = binding.etPassword.text.toString()
                )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        loginViewModel.isLoginEnabled.observe(this) { isLoginEnabled ->
            binding.btnLogin.isEnabled = isLoginEnabled
            if (isLoginEnabled) {
                binding.tilPassword.helperText = " "
            } else {
                binding.tilPassword.helperText = getString(R.string.log_in_disabled)
            }
//            if (isLoginEnabled) startActivity(Intent(this@LoginActivity, EmptyActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this@LoginActivity, EmptyActivity::class.java))
        }
    }
}