package com.example.clean_digicala.bingsearch.data.api

import com.example.clean_digicala.bingsearch.data.entity.BingNewsEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface BingApiService {


    @GET("/v2/everything?q=apple&from=2022-11-08&to=2022-11-08&sortBy=popularity&apiKey=34534b86d45c4ddc8672670d4f7f7590")

    suspend fun getNews(): Response<BingNewsEntity>

}