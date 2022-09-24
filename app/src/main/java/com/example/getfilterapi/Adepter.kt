package com.example.getfilterapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ApiAdepter(val mainActivity: MainActivity, val list: List<ApiModelItem>?) :
    RecyclerView.Adapter<ApiAdepter.viewdata>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewdata {
        var view = LayoutInflater.from(mainActivity).inflate(R.layout.itemfile, parent, false)
        return viewdata(view)
    }

    override fun onBindViewHolder(holder: viewdata, position: Int) {

        holder.title_txt.text=list?.get(position)?.title
        holder.price_txt.text= list?.get(position)?.price.toString()
        holder.category_txt.text=list?.get(position)?.category
        holder.description_txt.text=list?.get(position)?.description

        Glide.with(mainActivity)  //2
            .load(list?.get(position)?.image) //3
            .centerCrop() //4
            .into(holder.image_img) //8
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    class viewdata(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image_img = itemView.findViewById<ImageView>(R.id.image_img)
        var title_txt = itemView.findViewById<TextView>(R.id.title_txt)
        var price_txt = itemView.findViewById<TextView>(R.id.price_txt)
        var description_txt = itemView.findViewById<TextView>(R.id.description_txt)
        var category_txt = itemView.findViewById<TextView>(R.id.category_txt)
    }

}