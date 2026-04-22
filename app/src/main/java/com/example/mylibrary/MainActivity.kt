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
import com.example.mylibrary.tugas_p2.KalkulatorBangunan
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import androidx.core.content.edit

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
        val sharedPref = getSharedPreferences("user_session", MODE_PRIVATE)

        binding.btnLogout.setOnClickListener { //pakai binding untuk lebih mempermudah pemanggilan id
            MaterialAlertDialogBuilder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin Logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    sharedPref.edit {
                        clear()
                    }
                    dialog.dismiss()
                    val intent = Intent(this, AuthActivity::class.java)
                    startActivity(intent)
                    finish()
                    dialog.dismiss()
                    Toast.makeText(
                        this,
                        "Anda telah Logout",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("Info Dialog","Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()
            //Mengambil value dari inputNama dan menampilkan di Logcat
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
        }
    }
}
