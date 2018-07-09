package com.lalo.recyclerviewfragments.fragment

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lalo.recyclerviewfragments.R
import com.lalo.recyclerviewfragments.adapter.ContactAdapter
import com.lalo.recyclerviewfragments.pojo.Contact
import com.lalo.recyclerviewfragments.presenter.IRecyclerViewFragmentPresenter
import com.lalo.recyclerviewfragments.presenter.RecyclerViewFragmentPresenter

class RecyclerViewFragment : Fragment(), IRecyclerViewFragmentView {
    //private val rvContacts by lazy { view!!.findViewById<RecyclerView>(R.id.rvContacts) }
    //private val irp by lazy { RecyclerViewFragmentPresenter(this, this.context!!) }
    private var rvContacts: RecyclerView? = null

    override fun createLinearLayoutVertical() {
        val llm : LinearLayoutManager = LinearLayoutManager(this.activity)
        llm.orientation = LinearLayoutManager.VERTICAL
        this.rvContacts?.layoutManager = llm
    }

    override fun createGridLayout() {
        var glm = GridLayoutManager(this.activity, 2)
        this.rvContacts?.layoutManager = glm
    }

    override fun createAdapter(lst: ArrayList<Contact>): ContactAdapter {
        return ContactAdapter(lst, this.activity as Activity)
    }

    override fun initAdapter(adapter: ContactAdapter) {
        this.rvContacts?.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var v = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        this.rvContacts = v.findViewById<RecyclerView>(R.id.rvContacts)
        RecyclerViewFragmentPresenter(this, this.context!!)

        return v;
    }
}
