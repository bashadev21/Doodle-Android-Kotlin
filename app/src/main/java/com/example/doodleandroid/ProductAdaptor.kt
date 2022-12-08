package com.example.doodleandroid

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdaptor(var list: ArrayList<User>,var recylerontap: RecyleronTap ):RecyclerView.Adapter<ProductAdaptor.ViewHolder>() {


    override fun onCreateViewHolder(parent:ViewGroup,ViewType:Int):ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder:ViewHolder, position:Int) {
        holder.text.text=list[position].name
        holder.ratingtxt.text=list[position].rating.toString()
        holder.btn.setOnClickListener(){
            recylerontap.onItemClickItemIncrement(position)
//            notifyDataSetChanged()

        }
        holder.text.setOnClickListener(){
            recylerontap.onItemClickRemove(position)
//        notifyDataSetChanged()

        }

    }
    override fun getItemCount():Int {
      return list.size
    }

    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        var text=view.findViewById<TextView>(R.id.product_name)
        var ratingtxt=view.findViewById<TextView>(R.id.rating_text)
        var btn=view.findViewById<View>(R.id.rating_btn)

    }
}
