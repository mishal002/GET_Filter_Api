package com.example.getfilterapi

import retrofit2.Call
import retrofit2.http.GET


//https://fakestoreapi.com/products
interface ApiInterface {

    @GET("products")

    fun getData(): Call<List<ApiModelItem>>


}