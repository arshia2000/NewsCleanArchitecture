package com.example.clean_digicala.bingsearch.data.network

import com.example.clean_digicala.bingsearch.data.entity.BingNewsEntity

interface SearchNewsDataSource {


    suspend fun getNews(): BingNewsEntity?

}