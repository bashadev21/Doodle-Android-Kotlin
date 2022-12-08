package com.example.doodleandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class HeaderAdaptor(): RecyclerView.Adapter<HeaderAdaptor.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, ViewType:Int):ViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.widget_circle_image,parent,false)


        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder:ViewHolder,position:Int) {




    }
    override fun getItemCount():Int {
        return 4
    }

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){

    }
}