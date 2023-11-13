package com.example.tugasretrofit_pertemuan11

import com.bumptech.glide.Glide
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasretrofit_pertemuan11.databinding.ActivityDetailHeroBinding

class DetailHeroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data hero dari intent
        val heroId = intent.getIntExtra("heroId", -1)
        val heroTitle = intent.getStringExtra("heroTitle")
        val heroImage = intent.getStringExtra("heroImage")

        // Mengisi tampilan dengan data hero
        binding.detailIdHero.text = "Hero ID: $heroId"
        binding.detailTitleHero.text = "Hero Title: $heroTitle"

        Glide.with(this)
            .load(heroImage)
            .into(binding.detailImageHero)

        // Mengatur fungsi untuk tombol kembali
        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed() // Menutup aktivitas dan kembali ke halaman sebelumnya
        }
    }
}