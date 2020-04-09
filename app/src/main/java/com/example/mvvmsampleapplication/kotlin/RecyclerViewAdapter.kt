package com.example.mvvmsampleapplication.kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmsampleapplication.R
import com.example.mvvmsampleapplication.java.User
import java.util.ArrayList

class RecyclerViewAdapter(private val context: MainActivity, private val userArrayList: ArrayList<DataModel>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return userArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var user: DataModel = userArrayList.get(position)
        holder.txtView_title.text = user.title
        holder.txtView_description.text = user.id.toString()

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgView_icon: ImageView
        var txtView_title: TextView
        var txtView_description: TextView

        init {
            imgView_icon = itemView.findViewById(R.id.imgView_icon)
            txtView_title = itemView.findViewById(R.id.txtView_title)
            txtView_description = itemView.findViewById(R.id.txtView_description)
        }
    }
}