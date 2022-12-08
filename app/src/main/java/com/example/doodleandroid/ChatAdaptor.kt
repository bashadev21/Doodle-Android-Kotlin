package com.example.doodleandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChatMainAdaptor(var list: ArrayList<String>):RecyclerView.Adapter<ChatMainAdaptor.ViewHolder>(){

    override fun getItemViewType(position: Int): Int {
        var type=0

         if(list[position].lowercase().contains("chat")){
             type=   2
        }else if(list[position].lowercase().contains("header")){
             type=   1
        }else if(list[position].lowercase().contains("checkin")){
             type=   3
         }
         else if(list[position].lowercase().contains("online")){
             type=   4
         }
       return type
    }
    override fun onCreateViewHolder(parent:ViewGroup,ViewType:Int): ViewHolder {
        when(ViewType.toString()){
            "1" -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.widget_blue_card,parent,false)
                return ViewHolder(view)
            }
            "2" -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.widget_chat_message,parent,false)
                return ViewHolder(view)
            }
            "3" -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.widget_check_in,parent,false)
                return ViewHolder(view)
            }
            "4" -> {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.widget_online,parent,false)
                return ViewHolder(view)
            }
        }

        val view=LayoutInflater.from(parent.context).inflate(R.layout.widget_online,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position:Int) {

        when(list[position]){
            "header" -> {
                holder.recyclerView.adapter = HeaderAdaptor()
            }
            "online" -> {
                holder.recyclerViewOnline.adapter = CarcassAdaptor()
            }
        }



    }
    override fun getItemCount():Int {
        return list.size
    }

    class ViewHolder(view :View):RecyclerView.ViewHolder(view){
        var recyclerView = view.findViewById<RecyclerView>(R.id.circle_list)
        var recyclerViewOnline = view.findViewById<RecyclerView>(R.id.carca_list)

    }

}



