package com.lalo.recyclerviewfragments.fragment

import android.support.v7.widget.LinearLayoutManager
import com.lalo.recyclerviewfragments.adapter.ContactAdapter
import com.lalo.recyclerviewfragments.pojo.Contact

interface IRecyclerViewFragmentView {
    fun createLinearLayoutVertical()
    fun createGridLayout()
    fun createAdapter(lst: ArrayList<Contact>): ContactAdapter
    fun initAdapter(adapter: ContactAdapter)
}