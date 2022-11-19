package com.example.clean_digicala.bingsearch.data.network

import android.util.Log
import com.example.clean_digicala.bingsearch.data.api.BingApiService
import com.example.clean_digicala.bingsearch.data.entity.BingNewsEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.connection.ConnectInterceptor.intercept
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.lang.Exception
import java.lang.String.format
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit

class SearchNewsDataSourceImpl:SearchNewsDataSource {



    private val BASE_URL = "https://newsapi.org"



//    var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//    val client = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(
//        30,
//        TimeUnit.SECONDS
//    ).addInterceptor(interceptor).build()




   private val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

  private  val bingService = retrofit.create(BingApiService::class.java)





    override suspend fun getNews(searchQuery:String): BingNewsEntity?= withContext(Dispatchers.IO) {



//        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
//        val current = LocalDateTime.now().format(formatter)
//        Log.e("date : ",current)


        try {
            val result = bingService.getNews(searchQuery,"2022-11-08","2022-11-08","popularity","34534b86d45c4ddc8672670d4f7f7590")
            if (result.isSuccessful) result.body() else null
        } catch (ex: Exception) {
            Log.e("retrofit call : ",ex.message.toString())
            null
        }


    }



}