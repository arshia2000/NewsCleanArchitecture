package com.example.clean_digicala.bingsearch.data.entity

import com.example.clean_digicala.bingsearch.domain.model.NewsModel
import com.google.gson.annotations.SerializedName

data class BingNewsEntity(

    @field:SerializedName("totalResults")
    val totalResults: Int? = null,

    @field:SerializedName("articles")
    var articles: List<ArticlesItem?>? = null,

    @field:SerializedName("status")
    val status: String? = null
) {


    fun toModel() = NewsModel(
        totalResults = totalResults ?: 0,
        articles = articles,
        status = status ?: "",


        )

}

data class Source(

    @field:SerializedName("Id")
    val id: String? = null,

    @field:SerializedName("Name")
    val name: String? = null
)

data class ArticlesItem(

    @field:SerializedName("publishedAt")
    var publishedAt: String? = null,

    @field:SerializedName("author")
    var author: String? = null,

    @field:SerializedName("source")
    val source: Source? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)
