package com.lalo.recyclerviewfragments.presenter

import android.content.Context
import android.util.Log
import com.lalo.recyclerviewfragments.db.ConstructorContacts
import com.lalo.recyclerviewfragments.fragment.IRecyclerViewFragmentView
import com.lalo.recyclerviewfragments.pojo.Contact
import com.lalo.recyclerviewfragments.restApi.adapter.RestApiAdapter
import com.lalo.recyclerviewfragments.restApi.model.ContactResponse
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

        //this.getContactsDB()
        this.getRecentMedia()
    }

    override fun getContactsDB() {
        this.lstContacts = this.cc.data
        this.showContactsRV()
    }

    override fun getRecentMedia() {
        val raa = RestApiAdapter()
        val ea = raa.setConnectionRestApiInstagram(raa.buildGsonDeserializerMediaRecent())
        val crc = ea.recentMedia
        crc.enqueue(object : Callback<ContactResponse> {
            override fun onResponse(call: Call<ContactResponse>, response: Response<ContactResponse>) {
                val cr = response.body()
                lstContacts = cr!!.lstContacts!!
                showContactsRV()
            }

            override fun onFailure(call: Call<ContactResponse>, t: Throwable) {
                Toast.makeText(ctx, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show()
                Log.e("FALLO LA CONEXION", t.toString())
            }
        })
    }

    override fun showContactsRV() {
        irv.initAdapter(irv.createAdapter(this.lstContacts))
        irv.createGridLayout()
    }
}