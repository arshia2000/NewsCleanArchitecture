package com.example.clean_digicala.bingsearch.data

import com.example.clean_digicala.bingsearch.data.entity.ArticlesItem
import com.example.clean_digicala.bingsearch.data.entity.BingNewsEntity
import com.example.clean_digicala.bingsearch.data.network.SearchNewsDataSource
import com.example.clean_digicala.bingsearch.data.network.SearchNewsDataSourceImpl
import com.example.clean_digicala.bingsearch.domain.BingSearchRepository

class BingSearchRepositoryImp(private var dataSource:SearchNewsDataSourceImpl): BingSearchRepository {



    override suspend fun getNews():BingNewsEntity {

        var articles= dataSource.getNews()?.articles as List<ArticlesItem>
        var data= dataSource.getNews()

        articles.map {

            if(it.author!=null) {
                it.author = "Written by " + it.author
            }else{
                it.author="unknown"
            }

        }

        data?.articles=articles


    return data!!

    }
}