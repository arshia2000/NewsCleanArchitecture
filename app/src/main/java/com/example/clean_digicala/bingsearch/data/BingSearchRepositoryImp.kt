package com.example.clean_digicala.bingsearch.data

import com.example.clean_digicala.bingsearch.data.entity.ArticlesItem
import com.example.clean_digicala.bingsearch.data.entity.BingNewsEntity
import com.example.clean_digicala.bingsearch.data.network.SearchNewsDataSource
import com.example.clean_digicala.bingsearch.data.network.SearchNewsDataSourceImpl
import com.example.clean_digicala.bingsearch.domain.BingSearchRepository

class BingSearchRepositoryImp(private var dataSource:SearchNewsDataSourceImpl): BingSearchRepository {


   private lateinit var articles:List<ArticlesItem>
   private var data:BingNewsEntity?=BingNewsEntity()



    override suspend fun getNews(searchQuery: String):BingNewsEntity? {

        if(dataSource.getNews(searchQuery)!=null) {


            articles = dataSource.getNews(searchQuery)?.articles as List<ArticlesItem>
             data = dataSource.getNews(searchQuery)



            articles.map {

                if (it.author != null) {
                    it.author = "Written by " + it.author
                    it.publishedAt=it.publishedAt?.substring(0,10).toString()
                    it.publishedAt=it.publishedAt?.replace("-","/")
                } else {
                    it.author = "unknown"
                }



            }



            data?.articles = articles

        }

    return data

    }





}