package com.example.clean_digicala.bingsearch.domain.model

import android.os.Parcelable
import com.example.clean_digicala.bingsearch.data.entity.ArticlesItem
import kotlinx.android.parcel.Parcelize

@Parcelize
class NewsModel(val totalResults: Int? = null,
                val articles: List<ArticlesItem?>? = null,
                val status: String? = null) : Parcelable

