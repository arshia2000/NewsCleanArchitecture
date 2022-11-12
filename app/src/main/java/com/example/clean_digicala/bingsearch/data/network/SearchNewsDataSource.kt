package com.example.clean_digicala.bingsearch.data.network

import com.example.clean_digicala.bingsearch.data.entity.BingNewsEntity
import retrofit2.http.Query

interface SearchNewsDataSource {


    suspend fun getNews(searchQuery:String): BingNewsEntity?

}