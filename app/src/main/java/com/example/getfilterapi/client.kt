package com.example.getfilterapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class client {

    companion object {
        var Url = "https://fakestoreapi.com/"

        fun getRetrofit(): Retrofit {
            return Retrofit.Builder().baseUrl(Url)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}