package com.example.project16k.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.project16k.R
import com.example.project16k.adapter.CustomAdapter
import com.example.project16k.helper.SpaceItemDecoration
import com.example.project16k.model.Member
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        refreshAdapter(prepareMemberList())

    }

    private fun initViews() {
        context = this
        recyclerView = recycler_view

        recyclerView.addItemDecoration(SpaceItemDecoration(5))
    }

    private fun refreshAdapter(members: ArrayList<Member>) {
        val customAdapter = CustomAdapter(context, members)
        recyclerView.adapter = customAdapter
    }

    private fun prepareMemberList(): ArrayList<Member> {
        val members: ArrayList<Member> = ArrayList<Member>()
        for (i in 1..100) {
            members.add(Member("Muhammadrizo$i", "Nurullaxo'jayev$i"))
        }
        return members
    }
}



