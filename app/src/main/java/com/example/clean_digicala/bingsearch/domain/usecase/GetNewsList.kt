package com.example.clean_digicala.bingsearch.domain.usecase

import com.example.clean_digicala.bingsearch.data.BingSearchRepositoryImp
import com.example.clean_digicala.bingsearch.data.entity.ArticlesItem
import com.example.clean_digicala.bingsearch.data.entity.BingNewsEntity
import com.example.clean_digicala.bingsearch.domain.BingSearchRepository
import com.example.clean_digicala.bingsearch.domain.model.NewsModel

class GetNewsList(private var repository:BingSearchRepositoryImp) {



    suspend fun getNews():NewsModel{


       return repository.getNews().toModel()

    }
}