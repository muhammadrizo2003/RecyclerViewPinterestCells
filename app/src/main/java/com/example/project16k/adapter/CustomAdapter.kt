package com.example.project16k.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project16k.R
import com.example.project16k.model.Member
import kotlinx.android.synthetic.main.item_custom_layout.view.*
import java.util.*

// this is a simple recycler view adapter
// recycler view pinterest cells
class CustomAdapter(private val context: Context, private val itemList: ArrayList<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_custom_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member: Member = itemList[position]

        // set data to item
        if (holder is CustomViewHolder) {

            holder.itemView.text_view_title.text = member.name
            val imageView = holder.itemView.findViewById<ImageView>(R.id.item_image_view)

            when {
                position % 3 == 0 -> {
                    imageView.setImageResource(R.drawable.ic_image_1)
                }
                position % 4 == 0 -> {
                    imageView.setImageResource(R.drawable.ic_image_2)
                }
                else -> {
                    imageView.setImageResource(R.drawable.ic_image_3)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    private class CustomViewHolder(
        val view: View,
        var txt_name: TextView = view.text_view_title,
        var imageView: ImageView = view.item_image_view
    ) : RecyclerView.ViewHolder(
        view
    )
}
