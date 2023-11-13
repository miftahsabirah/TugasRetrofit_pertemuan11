package com.example.tugasretrofit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugasretrofit_pertemuan11.DetailHeroActivity
import com.example.tugasretrofit_pertemuan11.R
import com.example.tugasretrofit_pertemuan11.model.SuperHeroData


class SuperHeroAdapter(var con: Context, var list: List<SuperHeroData>) : RecyclerView.Adapter<SuperHeroAdapter.SuperHeroViewHolder>() {

    //Mendapatkan referensi ke setiap textview dan imageview untuk menampilkan data
    inner class SuperHeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageHero: ImageView = itemView.findViewById(R.id.imageHero)
        val idHero: TextView = itemView.findViewById(R.id.idHero)
        val titleHero: TextView = itemView.findViewById(R.id.titleHero)


        //Mengikat data pahlawan ke tampilan yang sesuai di dalam ViewHolder.
        fun bind(superHero: SuperHeroData) {
            Glide.with(itemView)
                .load(superHero.image)
                .into(imageHero)
            idHero.text = superHero.id.toString()
            titleHero.text = superHero.title

            //Menambahkan OnClickListener ke itemView untuk menampilkan halaman detailhero saat item di-klik.
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailHeroActivity::class.java)
                intent.putExtra("heroId", superHero.id)
                intent.putExtra("heroTitle", superHero.title)
                intent.putExtra("heroImage", superHero.image)
                itemView.context.startActivity(intent)
            }

        }
    }

    //Membuat dan mengembalikan instance dari SuperHeroViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_hero, parent, false)
        return SuperHeroViewHolder(itemView)
    }

    //Mengembalikan jumlah total item dalam daftar hero
    override fun getItemCount(): Int {
        return list.size
    }

    //Memasukkan data hero ke ViewHolder pada posisi tertentu.
    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val currentItem = list[position]
        holder.bind(currentItem)
    }
}
