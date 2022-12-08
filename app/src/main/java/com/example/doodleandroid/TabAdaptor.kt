package com.example.doodleandroid

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class TabAdaptor(var context:Context,fm:FragmentManager,var totalTabs:Int):FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
       return when(position){
           0->{
               FirstFragment()


           }
           1->{
               SecondFragment()

           }
           else -> getItem(position)
       }
    }
    override fun getCount(): Int {
        return totalTabs
    }

}