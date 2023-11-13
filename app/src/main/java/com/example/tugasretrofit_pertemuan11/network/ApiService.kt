package com.example.tugasretrofit_pertemuan11.network

import com.example.tugasretrofit_pertemuan11.model.SuperHeroModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("superhero")
    fun getSuperHero(): Call<SuperHeroModel>
}