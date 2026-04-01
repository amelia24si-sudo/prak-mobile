package com.example.mylibrary.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylibrary.R
import com.example.mylibrary.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val inputNo: EditText = findViewById(R.id.inputNoTujuan)
//        val btnSubmit: Button = findViewById(R.id.btnkirim)

        binding.btnkirim.setOnClickListener { //pakai binding untuk lebih mempermudah pemanggilan id
            //Mengambil value dari inputNama dan menampilkan di Logcat
            val no = binding.inputNoTujuan.text
            Log.e("Klik btnSubmit", "Tombol berhasil di tekan. Isi dari inputNo = $no")

            Toast.makeText(this, "Anda telah melakukan klik pada tombol Submit $no", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)
        }
    }
}