package com.example.clean_digicala.bingsearch.di.module

import com.example.clean_digicala.bingsearch.data.BingSearchRepositoryImp
import com.example.clean_digicala.bingsearch.data.network.SearchNewsDataSourceImpl
import com.example.clean_digicala.bingsearch.domain.BingSearchRepository
import com.example.clean_digicala.bingsearch.domain.usecase.GetNewsList
import com.example.clean_digicala.bingsearch.presenter.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val BingNewsModule= module {

//    factory { BingSearchRepositoryImp(get()) }
//    factory { GetNewsList(get()) }


    factory { GetNewsList(BingSearchRepositoryImp(SearchNewsDataSourceImpl())) }
    viewModel{ NewsViewModel(get()) }


}