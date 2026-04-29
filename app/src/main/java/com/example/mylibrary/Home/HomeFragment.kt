package com.example.mylibrary.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.mylibrary.AuthActivity
import com.example.mylibrary.Home.pertemuan_2.SecondActivity
import com.example.mylibrary.Home.pertemuan_3.ThirdActivity
import com.example.mylibrary.Home.pertemuan_4.FourthActivity
import com.example.mylibrary.Home.pertemuan_5.FifthActivity
import com.example.mylibrary.Home.pertemuan_7.SeventhActivity
import com.example.mylibrary.R
import com.example.mylibrary.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        val sharedPref = requireContext().getSharedPreferences("user_session", MODE_PRIVATE)
        binding.btnLogout.setOnClickListener { //pakai binding untuk lebih mempermudah pemanggilan id
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin Logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    sharedPref.edit {
                        clear()
                    }
                    dialog.dismiss()
                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Tidak!")
                }
                .show()
        }
        binding.btnp7.setOnClickListener {
            val i = Intent(requireContext(), SeventhActivity::class.java)
            startActivity(i)
        }
        binding.btnp5.setOnClickListener {
            val i = Intent(requireContext(), FifthActivity::class.java)
            startActivity(i)
        }
        binding.btnp4.setOnClickListener {
            val i = Intent(requireContext(), FourthActivity::class.java)
            startActivity(i)
        }
        binding.btnp3.setOnClickListener {
            val i = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(i)
        }
        binding.btnp2.setOnClickListener {
            val i = Intent(requireContext(), SecondActivity::class.java)
            startActivity(i)
        }
    }
}