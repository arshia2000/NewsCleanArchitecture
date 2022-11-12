package com.example.clean_digicala.bingsearch.data.api

import com.example.clean_digicala.bingsearch.data.entity.BingNewsEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BingApiService {

  //  /v2/everything?q=apple&from=2022-11-08&to=2022-11-08&sortBy=popularity&apiKey=34534b86d45c4ddc8672670d4f7f7590

    @GET("/v2/everything")

    suspend fun getNews(@Query("q") search: String,@Query("from") from: String,@Query("to") to: String,@Query("sortBy") sortBy: String,@Query("apiKey") apiKey:String): Response<BingNewsEntity>

}