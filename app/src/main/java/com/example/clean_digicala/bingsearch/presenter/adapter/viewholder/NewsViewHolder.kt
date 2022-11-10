package com.example.clean_digicala.bingsearch.presenter.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.clean_digicala.R

class NewsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    var txt_title: TextView?=null
    var txt_publish: TextView?=null
    var layout:ConstraintLayout?=null

    init {

        txt_title=itemView.findViewById(R.id.custom_txt_title)
        txt_publish=itemView.findViewById(R.id.custom_txt_publishAt)
        layout=itemView.findViewById(R.id.custom_news_layout)

    }





}