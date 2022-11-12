package com.example.clean_digicala.bingsearch.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_digicala.bingsearch.data.entity.ArticlesItem
import com.example.clean_digicala.bingsearch.domain.usecase.GetNewsList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel( private var getNewsList: GetNewsList):ViewModel() {


    var data= MutableLiveData<List<ArticlesItem>>()


    fun getNews(searchQuery:String){


       viewModelScope.launch(Dispatchers.IO) {


          val array= getNewsList.getNews(searchQuery)?.articles as List<ArticlesItem>
          data.postValue(array)




       }
    }





}