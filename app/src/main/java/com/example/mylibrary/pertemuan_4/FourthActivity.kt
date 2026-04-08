package com.example.mylibrary.pertemuan_4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylibrary.MainActivity
import com.example.mylibrary.R
import com.example.mylibrary.databinding.ActivityFourthBinding
import com.example.mylibrary.databinding.ActivityMainBinding
import com.example.mylibrary.databinding.ActivityThirdBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.log

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("=== onCreate ===", "FourthActivity dibuat pertama kali")
        enableEdgeToEdge()
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup"){
                    Log.e("Info Snackbar","Snackbar ditutup")
                }
                .show()
        }

        binding.btnToMain.setOnClickListener { //pakai binding untuk lebih mempermudah pemanggilan id
            //Mengambil value dari inputNama dan menampilkan di Logcat
            Toast.makeText(
                this,
                "Anda telah memasuki halaman Main Activity",
                Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val age = intent.getIntExtra("age",0)
        Log.e("== Data Intent ==","Nama: $name , Usia: $age, Asal: $from")
    }

    override fun onStart() {
        super.onStart()
        Log.e("=== onStart ===", "onStart: FourthActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("=== onDestroy ===", "FourthActivity dihapus dari stack")
    }
}