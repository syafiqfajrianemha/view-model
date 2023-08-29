package com.emha.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.emha.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var viewModel: MainViewModel

    // menyingkat kode inisialisasi ViewModel dengan library activity-ktx
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        binding.btnCalculate.setOnClickListener {
            val width = binding.etWidth.text.toString()
            val height = binding.etHeight.text.toString()
            val length = binding.etLength.text.toString()
            when {
                width.isEmpty() -> {
                    binding.etWidth.error = "Masih kosong"
                }

                height.isEmpty() -> {
                    binding.etHeight.error = "Masih kosong"
                }

                length.isEmpty() -> {
                    binding.etLength.error = "Masih kosong"
                }

                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        binding.tvResult.text = viewModel.result.toString()
    }
}