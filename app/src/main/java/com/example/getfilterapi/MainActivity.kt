package com.example.getfilterapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.getfilterapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

     var list = arrayListOf<ApiModelItem>()
    var listFilter = arrayListOf<ApiModelItem>()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        API Calling
        productApi()
        binding.btn1.setOnClickListener {
            fil(50)
        }
        binding.btn2.setOnClickListener {
            fil(200)
        }
    }

        fun productApi() {
            var apiInterface = client.getRetrofit().create(ApiInterface::class.java)
            apiInterface.getData().enqueue(object : Callback<List<ApiModelItem>> {
                override fun onResponse(
                    call: Call<List<ApiModelItem>>,
                    response: Response<List<ApiModelItem>>,
                ) {
                     list = response.body() as ArrayList<ApiModelItem>
                    Log.e("TAG", "onResponse:----- ${response.body()?.get(0)!!.image}")

                    fil(100)
                }

                override fun onFailure(call: Call<List<ApiModelItem>>, t: Throwable) {
                    Log.e("TAG", "onResponse:----- ${t.message}")
                }
            })
        }

        fun fil(i: Int) {
            listFilter.clear()
            for (x in list) {

                var price = x.price
                Log.e("TAG", "fil: ${price}")
                if (price!! >= i || price!! <= i ) {
                    listFilter.add(x)
                }
            }
                adepter(listFilter)
        }

        fun adepter(list: List<ApiModelItem>?) {
            var adepter = ApiAdepter(this, list)
            var lm = LinearLayoutManager(this)
            binding.Rvview.adapter = adepter
            binding.Rvview.layoutManager = lm
        }

}