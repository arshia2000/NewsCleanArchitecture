package com.example.clean_digicala.bingsearch.domain.model

import com.example.clean_digicala.bingsearch.data.entity.ArticlesItem

class NewsModel(val totalResults: Int? = null,
                val articles: List<ArticlesItem?>? = null,
                val status: String? = null)

