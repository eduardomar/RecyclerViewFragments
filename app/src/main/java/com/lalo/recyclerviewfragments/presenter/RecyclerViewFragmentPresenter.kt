package com.lalo.recyclerviewfragments.presenter

import android.content.Context
import com.lalo.recyclerviewfragments.db.ConstructorContacts
import com.lalo.recyclerviewfragments.fragment.IRecyclerViewFragmentView
import com.lalo.recyclerviewfragments.pojo.Contact

class RecyclerViewFragmentPresenter : IRecyclerViewFragmentPresenter {
    private var irv: IRecyclerViewFragmentView
    private var ctx: Context
    private val cc: ConstructorContacts
    private var lstContacts: ArrayList<Contact>

    constructor(irv: IRecyclerViewFragmentView, ctx: Context) {
        this.irv = irv
        this.ctx = ctx
        this.cc = ConstructorContacts(ctx)
        this.lstContacts = ArrayList<Contact>()

        this.showContactsRV()
    }

    override fun getContactsDB() {
        this.lstContacts = this.cc.data
    }

    override fun showContactsRV() {
        this.getContactsDB()
        irv.initAdapter(irv.createAdapter(this.lstContacts))
        irv.createLinearLayoutVertical()
    }
}