package com.example.mylibrary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylibrary.databinding.ActivityAuthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Kode ini harus selalu dipanggil saat butuh akses "user_session"
        val sharedPref = getSharedPreferences("user_session", MODE_PRIVATE)

        //Kondisi jika isLogin bernilai true
        val isLogin = sharedPref.getBoolean("isLogin", false)
        if (isLogin) {
            //Panggil Intent untuk ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.btnLogin.setOnClickListener {
            val username = binding.inputUsername.text.toString()
            val password = binding.inputPassword.text.toString()

            if (username == password){
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username",username)
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

                Log.e("Info Dialog", "Anda memilih Ya!")

                Toast.makeText(this, "Anda telah login, selamat datang $username!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "Harap isi username dan password anda!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}