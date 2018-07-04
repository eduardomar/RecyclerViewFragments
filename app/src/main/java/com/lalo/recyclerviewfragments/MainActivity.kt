package com.lalo.recyclerviewfragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.Adapter
import com.lalo.recyclerviewfragments.adapter.PageAdapter
import com.lalo.recyclerviewfragments.fragment.PerfilFragment
import com.lalo.recyclerviewfragments.fragment.RecyclerViewFragment
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    val toolbar: Toolbar by lazy { findViewById(R.id.toolbar) as Toolbar }
    val tabLayout: TabLayout by lazy { findViewById(R.id.tabLayout) as TabLayout }
    val viewPager: ViewPager by lazy { findViewById(R.id.viewPager) as ViewPager }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)
        this.setSupportActionBar(toolbar)

        val fragments = ArrayList<Fragment>()
        fragments.add(PerfilFragment())
        fragments.add(RecyclerViewFragment())

        this.viewPager.adapter = PageAdapter(this.getSupportFragmentManager(), fragments)
        this.tabLayout.setupWithViewPager(this.viewPager)
    }
}
