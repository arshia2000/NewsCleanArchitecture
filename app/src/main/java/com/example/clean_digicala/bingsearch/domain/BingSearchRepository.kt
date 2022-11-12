package com.example.clean_digicala.bingsearch.domain

import com.example.clean_digicala.bingsearch.data.entity.BingNewsEntity


interface BingSearchRepository {

   suspend fun getNews(searchQuery: String):BingNewsEntity?

}