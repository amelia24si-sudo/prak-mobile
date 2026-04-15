package com.example.mylibrary.pertemuan_5

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mylibrary.R
import com.example.mylibrary.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Jurnal Ke-V" // Judul menyesuaikan CollapsingToolbar
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // IMPROVISASI SCROLLABLE CONTENT: Logika FAB memudar & Scroll ke atas
        binding.fabScrollToTop.hide() // Sembunyikan di awal
        binding.nestedScrollView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > 200 && !binding.fabScrollToTop.isShown) {
                binding.fabScrollToTop.show()
            } else if (scrollY <= 200 && binding.fabScrollToTop.isShown) {
                binding.fabScrollToTop.hide()
            }
        }

        binding.fabScrollToTop.setOnClickListener {
            binding.nestedScrollView.smoothScrollTo(0, 0)
            binding.appBarLayout.setExpanded(true, true) // Membuka CollapsingToolbar kembali
        }

        // IMPROVISASI VECTOR ASSET: Animasi Programmatic saat ditekan
        binding.btnWebView.setOnClickListener {

            // Animasi Vector Asset (ikon di dalam tombol bergeser)
            val animator = ObjectAnimator.ofFloat(binding.btnWebView, "iconPadding", 0f, 50f, 0f)
            animator.duration = 400
            animator.start()

            // Jeda sedikit agar animasi terlihat sebelum pindah halaman
            it.postDelayed({
                val intent = Intent(this, WebViewActivity::class.java)
                startActivity(intent)
            }, 300)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // IMPROVISASI OPTION MENU: Logika untuk Sub-Menu & Checkable Items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            R.id.action_search -> {
                Toast.makeText(this, "Mencari halaman...", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.text_small -> {
                item.isChecked = true
                Toast.makeText(this, "Ukuran Teks: Kecil", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.text_medium -> {
                item.isChecked = true
                Toast.makeText(this, "Ukuran Teks: Sedang", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.text_large -> {
                item.isChecked = true
                Toast.makeText(this, "Ukuran Teks: Besar", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}