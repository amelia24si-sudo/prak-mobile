package com.example.mylibrary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylibrary.databinding.ActivityMainBinding
import com.example.mylibrary.databinding.ActivityThirdBinding
import com.example.mylibrary.pertemuan_3.ThirdResultActivity
import com.example.mylibrary.pertemuan_4.FourthActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnToFourrth.setOnClickListener { //pakai binding untuk lebih mempermudah pemanggilan id
            //Mengambil value dari inputNama dan menampilkan di Logcat
            Toast.makeText(
                this,
                "Anda telah memasuki halaman Fourth Activity",
                Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
            finish()
        }
    }
}
