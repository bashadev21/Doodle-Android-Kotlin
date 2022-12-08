package com.example.doodleandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PageViewAdaptor(private var title:List<String>):RecyclerView.Adapter<PageViewAdaptor.Pager2ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, ViewType:Int):Pager2ViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.widget_view_pager,parent,false)


        return Pager2ViewHolder(view)
    }
    override fun onBindViewHolder(holder:Pager2ViewHolder,position:Int) {

holder.text.text=title[position]


    }
    override fun getItemCount():Int {
        return title.size
    }

    class Pager2ViewHolder(view : View): RecyclerView.ViewHolder(view){

        var text=view.findViewById<TextView>(R.id.txt_slider_title)


    }
}