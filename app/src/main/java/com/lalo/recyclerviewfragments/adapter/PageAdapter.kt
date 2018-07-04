package com.lalo.recyclerviewfragments.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager, fragments: ArrayList<Fragment>) : FragmentPagerAdapter(fm) {
    private val fragments: ArrayList<Fragment> = fragments

    override fun getItem(index: Int): Fragment {
        return this.fragments.get(index)
    }

    override fun getCount(): Int {
        return this.fragments.size
    }
}