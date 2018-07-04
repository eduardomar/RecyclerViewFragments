package com.lalo.recyclerviewfragments.fragment

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lalo.recyclerviewfragments.R
import com.lalo.recyclerviewfragments.adapter.ContactAdapter
import com.lalo.recyclerviewfragments.pojo.Contact

class RecyclerViewFragment : Fragment() {
    private var rvContacts: RecyclerView?
    private val lstContacts : ArrayList<Contact>
    private val llm : LinearLayoutManager

    init {
        this.rvContacts = null
        this.lstContacts = ArrayList()
        this.lstContacts.add(Contact(R.drawable.ic_tongue_emoticon, "Eduardo Ramírez", "445 104 61 86", "eramirez@freshsoftwareconcepts.com"))
        this.lstContacts.add(Contact(R.drawable.ic_confused_emoticon, "Carlos Fuentes", "+1 (520) 245-2866", "cfuentes@freshsoftware.co"))
        this.lstContacts.add(Contact(R.drawable.ic_love_emoticon, "Enrique Noriega", "+1 (520) 245-2866", "enrique@freshsoftware.co"))
        this.lstContacts.add(Contact(R.drawable.ic_mute_emoticon, "Javier Barajas", "445 108 5650", "javierbarajas@freshsoftwareconcepts.com"))
        this.lstContacts.add(Contact(R.drawable.ic_tired_emoticon, "Huberto Luna", "662 338 2046", "uluna@freshsoftwareconcepts.com"))

        this.llm = LinearLayoutManager(this.activity)
        this.llm.orientation = LinearLayoutManager.VERTICAL
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var v = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        this.rvContacts = v.findViewById(R.id.rvContacts) as RecyclerView
        this.rvContacts?.layoutManager = llm
        this.rvContacts?.adapter = ContactAdapter(this.lstContacts, getActivity() as Activity)

        return v;
    }
}
